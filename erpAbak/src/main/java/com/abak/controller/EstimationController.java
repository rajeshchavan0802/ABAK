package com.abak.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abak.service.IEstimationCloningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abak.entity.Panel;
import com.abak.entity.PanelDetails;
import com.abak.entity.Project;
import com.abak.service.EstSheetService;
import com.abak.service.ISalesService;



@Controller
@RequestMapping("/estimation")
public class EstimationController {
	
	@Autowired
	private EstSheetService estSheetService;
	
	@Autowired
	private ISalesService salesService;

	@Autowired
	private IEstimationCloningService estimationCloningService;
	
	/*get the all project grid for Create estimation*/
	@RequestMapping(params="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEstimationIndexPage() {
		
		ModelAndView modelAndView = new ModelAndView("estimationIndex");
		List<Project> projects = salesService.getAllProject();
		
		for(Project p : projects) {
			
		if(p.getIsEstimationCreated()==null) {
			p.setIsEstimationCreated(false);
			}
		
		}
		modelAndView.addObject("listProject", projects);
		return modelAndView;
	}
	
	
	@RequestMapping(params="createEstimationTemplate",method={RequestMethod.GET,RequestMethod.POST})
	@Transactional
	public ModelAndView createEstimationView(@RequestParam String projectId,HttpServletRequest request) throws CloneNotSupportedException{
		
		Project project = salesService.getProjectById(Integer.valueOf(projectId));
		project.setPanels((project.getPanels().isEmpty() ? new ArrayList<Panel>() : project.getPanels()));
		
		Project project1 = (Project)project.clone(); 
		
		Map<Integer,Panel> panalList = new HashMap<>();
		Integer panalListCount = 0;
		
		HttpSession session = request.getSession();
		session.setAttribute("project", project1);
		session.setAttribute("panalList", panalList);
		session.setAttribute("panalListCount", panalListCount);
		ModelAndView modelAndView = new ModelAndView("new_estimation");
		modelAndView.addObject("project", project);
		return modelAndView;
	}
	
	
	@RequestMapping(params="openEstimationDetailsPopUp",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEstimationDetailsPopUp(){
		ModelAndView modelAndView = new ModelAndView("newEstimationPopUp");
		return modelAndView;
	}
	
	
	@RequestMapping(params="savePanalEntryInSession",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String,String> savePanalEntryInSession(@ModelAttribute Panel panel,HttpServletRequest request,HttpServletResponse response,BindingResult bindingResult){
		
		panel.setPanelDetailses(this.removeNullvalues(panel.getPanelDetailses()));
		List<PanelDetails> tempDetails= this.removeNullvalues(panel.getPanelDetailses());
		panel.setPanelDetailses(null);
		panel.setPanelDetailses(tempDetails);
		
		
		Map<String,String> result = new HashMap<>();
		HttpSession httpSession= request.getSession();
		//Project projectSession = (Project)httpSession.getAttribute("project");
		Map<Integer,Panel> panalList = (Map)httpSession.getAttribute("panalList");
		Integer panalListCount;
		
		if(panel.getPanelId()==null) {
			panalListCount = (Integer)httpSession.getAttribute("panalListCount")+1;
			panel.setPanelId(panalListCount);
			panalList.put(panalListCount, panel);
			httpSession.setAttribute("panalListCount", panalListCount);
		}else {
			panalListCount = panel.getPanelId();
			panalList.put(panalListCount, panel);
		}
		
		Double unitRate = (panel.getGrandRounedTotal()!=null ? panel.getGrandRounedTotal() : 0D );
		Double total = unitRate * (panel.getQuntity()!=null ? panel.getQuntity() : 0);
		result.put("srNo", panalListCount.toString());
		result.put("description",panel.getPanelName());
		result.put("qty",(panel.getQuntity()!=null ? panel.getQuntity().toString(): ""));
		result.put("unitRate",unitRate.toString());
		result.put("total",total.toString());
		result.put("hight","");
		result.put("width","");
		result.put("defth","");
		result.put("panelKey",panalListCount.toString());
		return result;
	}
	
	
	public List<PanelDetails> removeNullvalues(List<PanelDetails> panelDetailses) {
		 
		
		List<PanelDetails> newList = new ArrayList<>();
		
		for(PanelDetails tempDetails : panelDetailses) {
			
			if(tempDetails.getDescription()!=null && tempDetails.getGroupName()!=null) {
				newList.add(tempDetails);
				
			}
			
		}
		
		
		return newList;
	}

	@RequestMapping(params="estimationDetailsPopUp",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEstimationDetailsPopUp(@RequestParam String panelKey, @RequestParam String viewType,HttpServletRequest request){
		
		ModelAndView modelAndView ;
		
		if(viewType.equalsIgnoreCase("w")) {
			modelAndView = new ModelAndView("estimationDetailsPopUp");
		}else {
			modelAndView = new ModelAndView("estimationDetailsPopUpReadOnly");
		}
		
		HttpSession httpSession= request.getSession();
		Map<Integer,Panel> panalList = (Map)httpSession.getAttribute("panalList");
		Panel panel = panalList.get(Integer.valueOf(panelKey));
		modelAndView.addObject("panel", panel);
		Map<String,List<PanelDetails>> mapOfPanelDetails = this.getMapOfPanelDetails(panel.getPanelDetailses());
		modelAndView.addObject("panelDetailsesMap",mapOfPanelDetails);
		return modelAndView;
	}
	
	public Map<String,List<PanelDetails>> getMapOfPanelDetails(List<PanelDetails> list){
		
		Map<String,List<PanelDetails>> map = new LinkedHashMap<>();
		
		for(PanelDetails panelDetails: list) {
			
			if(map.containsKey(panelDetails.getGroupName())) {
				
				map.get(panelDetails.getGroupName()).add(panelDetails);
				
			}else {
				List<PanelDetails> details = new ArrayList<PanelDetails>();
				details.add(panelDetails);
				if(panelDetails.getGroupName()!=null)
				map.put(panelDetails.getGroupName(), details);
			}
	
		}
		return map;
	}
	
	@RequestMapping(params="save",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String saveEstimation(@ModelAttribute Project project,HttpServletRequest request) {
		
		System.out.println("This is the entry of estimation ");
		HttpSession httpSession= request.getSession();
		Map<Integer,Panel> panalList = (Map)httpSession.getAttribute("panalList");
		Project sessionProject = (Project)httpSession.getAttribute("project");
		estSheetService.getProjectForSave(project, sessionProject, panalList);
		sessionProject.setIsEstimationCreated(true);
		sessionProject.setIsQuotationPresent(false);
		estSheetService.saveEstimation(sessionProject);
		httpSession.removeAttribute("project");
		httpSession.removeAttribute("panalList");
		return "ok";
	}
	
	
	
	@RequestMapping(params="viewEstimation",method={RequestMethod.GET,RequestMethod.POST})
	@Transactional
	public ModelAndView viewEstimation(@RequestParam String projectId, @RequestParam String viewType,HttpServletRequest request){
		
		Project project = salesService.getProjectById(Integer.valueOf(projectId));
		project.setPanels(project.getPanels());
		Map<Integer,Panel> panalList = estSheetService.getPanelDetailsMap(project.getPanels()) ;
		Integer panalListCount = 0;
		
		HttpSession session = request.getSession();
		session.setAttribute("project", project);
		session.setAttribute("panalList", panalList);
		session.setAttribute("panalListCount", project.getPanels().size());
		
		ModelAndView modelAndView = null;
		
		if(viewType.equalsIgnoreCase("w")) {
		 
			modelAndView = new ModelAndView("VeiwOrEditEstimation");	
		
		}else {
		
			modelAndView = new ModelAndView("readOnlyEstimation");
		}
		
		
		modelAndView.addObject("project", project);
		return modelAndView;
	}
	
	
	@RequestMapping(params="estimationCloneIndex",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getEstimationCloneIndex() {
	 
		ModelAndView modelAndView = new ModelAndView("estimationCloneIndex");
		return modelAndView;
		
	}
	
	
	@RequestMapping(params="getDataForEstClone",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Object[]> getDataForEstClone(@RequestParam String enquiryNumber, @RequestParam String projectName){
		
		return estSheetService.getDataForEstClone(enquiryNumber,projectName);
		
	}

	@RequestMapping(params="doEstimationCloning",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String doCloning(@RequestParam String sourceID, @RequestParam String destinationId){

		estimationCloningService.doCloning(Integer.valueOf(sourceID),Integer.valueOf(destinationId));
		System.out.println(sourceID+ "   "+ destinationId);
		return "ok";
	}


}
