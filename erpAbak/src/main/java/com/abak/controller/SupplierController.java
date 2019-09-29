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

import com.abak.entity.SupplierDetails;
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
		return modelAndView;
	}
	
	@RequestMapping(params="save",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String saveSupplierMasters(@ModelAttribute SupplierMaster supplierMaster,
			HttpServletRequest request,HttpServletResponse response,BindingResult bindingResult) {
		System.out.println("This is the entry of supplier ");
		//SupplierDetails supplierDetails = new SupplierDetails();
		//supplierDetails.setMakeDescription(makeDescription);
		//supplierDetailsEntity.setSupplierNumber(1);
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
	
	
}
