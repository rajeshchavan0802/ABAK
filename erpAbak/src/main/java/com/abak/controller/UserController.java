package com.abak.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abak.dao.UserDao;
import com.abak.dao.UserTypeDao;
import com.abak.entity.UserEntity;
import com.abak.entity.UserTypeEntity;
import com.abak.model.UserModel;
import com.abak.service.UserService;
import com.abak.utility.Base64Password;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private UserTypeDao userTypeDao;
	private  String password;
	
	@RequestMapping(value="/",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginUser(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("adminLogin");
		return modelAndView;
	}
	
	@RequestMapping(value="/dashboard",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userDashboard(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("header");
		return modelAndView;
	}
	
	@RequestMapping(value="/addUser",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userAddByadmin(@ModelAttribute("userModel")UserModel userModel,HttpServletRequest request,HttpServletResponse response){
		List<UserTypeEntity> userTypeEntities = userTypeDao.listOfUserType();
		ModelAndView modelAndView = new ModelAndView("addUser");
		modelAndView.addObject("addUser");
		modelAndView.addObject("userModel", userModel);
		modelAndView.addObject("userTypeEntities", userTypeEntities);
		return modelAndView;
	}
		
	@RequestMapping(value="/loginCheck",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView userloginAction(@ModelAttribute("userModel")UserModel userModel,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Base64Password base64Password = new Base64Password();
		String password = base64Password.encodePassword(userModel.getPassword());
		UserEntity userEntity = userDao.loginCheck(userModel.getUsername(), password);
		String target ="";
		UserEntity userEntity2 = null;
		if(userEntity != null){
			HttpSession session= request.getSession();
			session.setAttribute("USERENTITY", userEntity);
			userEntity2 = (UserEntity) session.getAttribute("USERENTITY");
			target = "redirect:dashboard";
		}else{
			target = "redirect:adminLogin";
		}
		ModelAndView modelAndView = new ModelAndView(target);
		modelAndView.addObject("USERENTITY", userEntity2);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/svUserdetails",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView createUserData(@ModelAttribute("userModel")UserModel userModel,HttpServletRequest request,
			HttpServletResponse response,BindingResult result,RedirectAttributes redirectAttributes){
		UserEntity userEntity = PrepareCreateUserModel(userModel);
		HttpSession session=request.getSession(false);
		UserEntity userEntity2 = (UserEntity) session.getAttribute("USERENTITY");
		int userid = userEntity2.getId();
		try{
			userEntity.setCreatedBy(userid);
			userEntity.setIsRemoved(0);
			userEntity.setIsActive(1);
			Base64Password base64Password = new Base64Password();
			String encodedPassword = base64Password.encodePassword(userModel.getPassword());
			userEntity.setPassword(encodedPassword);
			userService.saveNewUserdetails(userEntity);
			userModel.setMessage("User Added SuccessFully");
		}catch(Exception e){
			System.out.println(e.getMessage());
			userModel.setMessage("Something went wrong");
		}
		redirectAttributes.addFlashAttribute("userModel", userModel);
		String target ="redirect:addUser";
		ModelAndView modelAndView = new ModelAndView(target);
		return modelAndView;
	}
	
	private UserEntity PrepareCreateUserModel(UserModel userModel){
		
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userModel.getFirstName());
		userEntity.setLastName(userModel.getLastName());
		userEntity.setEmailId(userModel.getEmailId());
		userEntity.setUsername(userModel.getUsername());
		userEntity.setPassword(userModel.getPassword());
		userEntity.setPriMobileNumber(userModel.getPriMobileNumber());
		userEntity.setSecMobileNumber(userModel.getSecMobileNumber());
		userEntity.setDesignation(userModel.getDesignation());
		userEntity.setUserTypeId(userModel.getUserTypeId());
		userEntity.setIsActive(userModel.getIsActive());
		userEntity.setIsRemoved(userModel.getIsRemoved());
		userEntity.setCreatedBy(userModel.getCreatedBy());
		userEntity.setCreatedDatetime(userModel.getCreatedDatetime());
		return userEntity;
		
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logoutUser(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println(session.getId());
		String target ="adminLogin";
		ModelAndView modelAndView = new ModelAndView(target);
		modelAndView.addObject(target);
		return modelAndView;
	}
	 
	
	
}
