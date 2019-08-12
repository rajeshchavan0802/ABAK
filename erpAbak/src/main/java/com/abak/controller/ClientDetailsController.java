package com.abak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abak.entity.ClientDetailsEntity;
import com.abak.model.ClientDetailsModel;
import com.abak.service.ClientDetailsService;

@Controller
public class ClientDetailsController {
	
	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@RequestMapping(value="/client",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView clientDetails(@ModelAttribute("clientDetailsModel")ClientDetailsModel clientDetailsModel,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("client");
		modelAndView.addObject("client");
		modelAndView.addObject("clientDetailsModel", clientDetailsModel);
		return modelAndView;
	}
	
	@RequestMapping(value="/clientsv",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView clientSaveDetils(@ModelAttribute("clientDetailsModel")ClientDetailsModel clientDetailsModel,HttpServletRequest request,
			HttpServletResponse response,BindingResult result,RedirectAttributes redirectAttributes){
		ClientDetailsEntity clientDetailsEntity=PrepareClientModel(clientDetailsModel);
		try{
			clientDetailsService.svClientDetails(clientDetailsEntity);
			clientDetailsModel.setClientMessage("Client Detials Save Successfully");
		}catch(Exception e){
			e.printStackTrace();
			clientDetailsModel.setClientMessage("Something went worng !!! please try again");
		}
		redirectAttributes.addFlashAttribute("clientDetailsModel", clientDetailsModel);
		String target="redirect:client";
		ModelAndView modelAndView=new ModelAndView(target);
		return modelAndView;
	}
	
	private ClientDetailsEntity PrepareClientModel(ClientDetailsModel clientDetailsModel){
		ClientDetailsEntity clientDetailsEntity=new ClientDetailsEntity();
		clientDetailsEntity.setClientName(clientDetailsModel.getClientName());
		clientDetailsEntity.setClientAddress(clientDetailsModel.getClientAddress());
		clientDetailsEntity.setClientLandline(clientDetailsModel.getClientLandline());
		clientDetailsEntity.setClientPhoneNo(clientDetailsModel.getClientPhoneNo());
		clientDetailsEntity.setClientNote(clientDetailsModel.getClientNote());
		clientDetailsEntity.setClientCreatedBy(clientDetailsModel.getClientCreatedBy());
		clientDetailsEntity.setClientCreatedDatetime(clientDetailsModel.getClientCreatedDatetime());
		return clientDetailsEntity;
	}
}
