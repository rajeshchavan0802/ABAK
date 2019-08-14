package com.abak.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.abak.entity.Project;
import com.abak.model.ProjectInformation;
import com.abak.service.ClientDetailsService;
import com.abak.service.ISalesService;
import com.abak.service.UserService;
import com.abak.utility.AbakConstant;
import com.abak.validation.SalesValidation;



@Controller
@RequestMapping("/sales")
public class SalesController {
	
	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SalesValidation validation;
	
	@Autowired
	private ISalesService salesService;
	

	@RequestMapping(params="newSalseEntry", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView indexSales(@ModelAttribute("project")Project project) {
		ModelAndView mv = new ModelAndView("newSalseEntry");
		
		Project p = new Project();
		mv.addObject("project",p);
		mv.addObject("errorList",new ArrayList<String>());
		mv.addObject("clientList",clientDetailsService.getAllClientDetailsEntity());
		mv.addObject("userList", userService.getAllUsers());
		return mv;
	}
	
	
	@RequestMapping(params="add",headers=("content-type=multipart/*"), method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String,String> newSalesEntry(@RequestParam("file") MultipartFile file,MultipartHttpServletRequest request,@ModelAttribute("project")Project project) {
		
		Map<String,String> result = new HashMap<>();
		List<String> errorList = new ArrayList<>();
		errorList = validation.validatedSalesEntry(project);
		String filepath = null ;
		try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            filepath = AbakConstant.UPLOADED_FOLDER + file.getOriginalFilename();
            Path path = Paths.get(filepath);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
		 
		 if(errorList.isEmpty()) {
			 //project.setEnquiryRecDate(new Date());
			 project.setCreatedOn(new Date());
			 project.setStatus("New sales entry");
			 project.setDocumentPathBySalse(filepath);
			 project.setIsEstimationCreated(false);
			 project.setIsQuotationPresent(false);
			 salesService.saveProject(project);
			 errorList.add("New sales Entry has been save successfully!");
			 //result.addAll(errorList);
			 result.put("msg","New sales Entry has been save successfully!!!");
		 }
		 
		return result;
	}
	
	@RequestMapping(params="viewPendingSalesOrder", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewSalesOrder() {
		ModelAndView mv = new ModelAndView("viewPendingOrders");
		List<Project> listProject = salesService.getAllProject();
		mv.addObject("listProject",listProject);
		return mv;
	}
	
	
	@RequestMapping(params="viewSalesOrderInfo", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ProjectInformation viewSalesOrderInfo(@RequestParam String projectId) {
		Integer id = new Integer(projectId);
		ProjectInformation projectInformation = salesService.getProjectInformation(id);
		return projectInformation;
	}	
	
	@RequestMapping(value ="viewEstimation", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewEstimation(@RequestParam String projectId, @RequestParam String viewType,HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:estimation?viewEstimation");
		return modelAndView;
	}
	
	
	
	
}
