package com.abak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abak.entity.UserEntity;
import com.abak.entity.UserTypeEntity;
import com.abak.model.UserTypeModel;
import com.abak.service.UserTypeService;

@Controller
public class UserTypeController {
	
	@Autowired
	private UserTypeService userTypeService;
	
	@RequestMapping(value="/userRole",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userRole(@ModelAttribute("userTypeModel")UserTypeModel userTypeModel,HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("userRole");
		modelAndView.addObject("userRole");
		modelAndView.addObject("userTypeModel", userTypeModel);
		return modelAndView;
	}
	
	@RequestMapping(value="/userRoleAdd", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userRoleAddDetials(@ModelAttribute("userTypeModel")UserTypeModel userTypeModel,HttpServletRequest request,
			HttpServletResponse response,RedirectAttributes redirectAttributes){
		UserTypeEntity userTypeEntity = PrepareModelUserRole(userTypeModel);
		HttpSession session=request.getSession(false);
		UserEntity userEntity = (UserEntity) session.getAttribute("USERENTITY");
		int userid = userEntity.getId();
		try{
			userTypeEntity.setIsActive(1);
			userTypeEntity.setIsremoved(0);
			userTypeEntity.setCretaedby(userid);
			userTypeService.saveUserType(userTypeEntity);
			userTypeModel.setMessage("User role Addedd !!!");
		}catch(Exception exception){
			userTypeModel.setMessage("SomeThing Went Wrong");
		}
		redirectAttributes.addFlashAttribute("userTypeModel", userTypeModel);
		String target = "redirect:userRole";
		ModelAndView modelAndView = new ModelAndView(target);
		return modelAndView;
	}
	
	private UserTypeEntity PrepareModelUserRole(UserTypeModel userTypeModel){
		UserTypeEntity userTypeEntity= new UserTypeEntity();
		userTypeEntity.setName(userTypeModel.getName());
		userTypeEntity.setIsActive(userTypeModel.getIsActive());
		userTypeEntity.setIsremoved(userTypeModel.getIsremoved());
		userTypeEntity.setCretaedby(userTypeModel.getCretaedby());
		return userTypeEntity;
	}
}
