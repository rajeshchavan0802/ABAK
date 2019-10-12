package com.abak.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abak.entity.SupplierMaster;
import com.abak.service.SupplierMasterService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierMasterService supplierMasterService;
	
	@RequestMapping(params="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getSupplierIndexPage() {
		ModelAndView modelAndView = new ModelAndView("supplierMaster");
		SupplierMaster supplierMaster = null;
		modelAndView.addObject("supplierMaster",supplierMaster);
		return modelAndView;
	}
	
	@RequestMapping(params="save",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String saveSupplierMasters(@ModelAttribute SupplierMaster supplierMaster,
			HttpServletRequest request,HttpServletResponse response,BindingResult bindingResult) {
		System.out.println("This is the entry of supplier ");
		supplierMasterService.saveSupplierMaster(supplierMaster);
		return "ok";
	}
	
	@RequestMapping(params="supplierDashboard",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getSupplierDashBoardPage() {
		ModelAndView modelAndView = new ModelAndView("supplierDashboard");
		List<SupplierMaster> listSupplier = supplierMasterService.getAllSupplier();
		modelAndView.addObject("listSupplier",listSupplier);
		return modelAndView;
	}
	
	@RequestMapping(params="viewSupplierInfo", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewSupInfo(@RequestParam Integer supplierNumber,@RequestParam Integer requestType ,HttpServletRequest request) {
		ModelAndView modelAndView = null;
		if(requestType ==1){
			modelAndView = new ModelAndView("supplierMasterReadOnly");
			SupplierMaster supplierMaster = supplierMasterService.getSupplierDataInfo(supplierNumber);
			modelAndView.addObject("supplierMaster",supplierMaster);
		}else if(requestType ==2){
			modelAndView = new ModelAndView("supplierMaster");
			SupplierMaster supplierMaster = supplierMasterService.getSupplierDataInfo(supplierNumber);
			//supplierMasterService.saveSupplierMaster(supplierMaster);
			modelAndView.addObject("supplierMaster",supplierMaster);
		}else{
			modelAndView = new ModelAndView("supplierDashboard");
			int res = supplierMasterService.deleteSupllierDataDetails(supplierNumber);
			List<SupplierMaster> listSupplier = supplierMasterService.getAllSupplier();
			modelAndView.addObject("listSupplier",listSupplier);			
		}
		return modelAndView;
	}

}
