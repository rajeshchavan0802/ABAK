package com.abak.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abak.dao.EstSheetDao;
import com.abak.entity.Panel;
import com.abak.entity.PanelAdditionalComponent;
import com.abak.entity.PanelDetails;
import com.abak.entity.PanelSpecification;
import com.abak.entity.Project;
import com.abak.utility.AbakConstant;



@Service
public class EstSheetService{
	
	@Autowired
	private EstSheetDao iEstSheetDao;
	
	@Transactional
	public void saveEstimation(Project project) {
		
		iEstSheetDao.saveEstimation(project);
	}
	
	
	@Transactional
	public Project getProjectForSave(Project project, Project sessionProject, Map<Integer,Panel> panalList) {
		
		List<Panel> panelList = new ArrayList<>();
		List<Panel> panelListAlreadyExist = sessionProject.getPanels();
		
		for(Map.Entry<Integer,Panel>  panelMap : panalList.entrySet()) {
			Panel panel = panelMap.getValue();
			
			this.setPanal(panel,sessionProject.getProjectId());
			
			panel.setProject(sessionProject);
			
			if(!this.ifAlreadyExist(panelListAlreadyExist, panel)) {
				panel.setPanelId(null);
			}
			
			panelList.add(panel);
		}
		
		if(panelListAlreadyExist!=null) {
			sessionProject.getPanels().removeAll(panelListAlreadyExist);
		}
		
		sessionProject.setPanels(panelList);
		
		return sessionProject;
	}
	
	public boolean ifAlreadyExist(List<Panel> list, Panel panel) {
		
		boolean result=false;
		
		for(Panel tempPanel : list) {
			
			if(tempPanel.getPanelId()==panel.getPanelId()) {
				 result=true;
				 break;
			}
			
		}
		
		return result;
		
	}
	
	public void setPanal(Panel panel,Integer projectId) {
		
		for(PanelAdditionalComponent  additionalComponent : panel.getPanelAdditionalComponents()) {
			additionalComponent.setPanel(panel);
			additionalComponent.setProjectId(projectId);
		}
		
		for(PanelDetails details: panel.getPanelDetailses()) {
			details.setPanel(panel);
			details.setProjectId(projectId);
		}
		
		for(PanelSpecification specification : panel.getPanelSpecifications()) {
			specification.setPanel(panel);
			specification.setProjectId(projectId);
		}
		
		
	}
	
	
	public Map<Integer,Panel> getPanelDetailsMap(List<Panel> list){
		
		Map<Integer,Panel> returnMap = new HashMap<>();
		
		for(Panel panel : list) {
			
			returnMap.put(panel.getPanelId(), panel);
			
		}
		
		
		return returnMap;
	}
	
	
	
	@Transactional
	public List<Object[]>  getDataForEstClone(String enquiryNumber, String projectName){
		
		List<Object[]> result = new ArrayList<>();
		Object[] temp;
		List<Object[]> projectList = iEstSheetDao.getProjectsByEnquiryNo(Integer.valueOf(enquiryNumber),projectName);
		
		for(Object[] project : projectList) {
		
			temp=new Object[5];
			
			temp[0]=project[0];
			
			temp[1]=(project[1] != null ? project[1].toString() : AbakConstant.BlanckString) + AbakConstant.ARROW + (project[5] != null ? project[5].toString() : AbakConstant.BlanckString);
			
			temp[2]=project[2];
			temp[3]=project[3];
			temp[4]=project[4];
			result.add(temp);

		}
		
		
		
		return result;
	}
	
	
	
	@Transactional
	  public boolean deleteFromPanelDetails(Integer panelId, String panalDetailsDelIDs,String panalDetailsDelGroups) {
		  boolean result = false;
		  String[] panalDetailsDelIDsArray = ( panalDetailsDelIDs!=null) ?  panalDetailsDelIDs.split(",") : null;
		  String[] panalDetailsDelGroupsArray = panalDetailsDelGroups!=null? panalDetailsDelGroups.split(",") : null;
		  Integer[] detailsIds = new Integer[panalDetailsDelIDsArray!=null?panalDetailsDelIDsArray.length : 0];
		  
		  if(panalDetailsDelIDsArray!=null)
		  for(int i =0 ;  i < panalDetailsDelIDsArray.length ; i++) {
			  detailsIds[i] = new Integer(panalDetailsDelIDsArray[i]);
		  }
		  
		  result = iEstSheetDao.deleteFromPanelDetails(panelId, detailsIds, panalDetailsDelGroupsArray);
		  
		  return result;
	  }
	
	
	
}
