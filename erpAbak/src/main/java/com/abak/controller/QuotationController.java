package com.abak.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.abak.dto.QuotationReportDTO;
import com.abak.dto.TestClass;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abak.dto.QuotationGrid;
import com.abak.entity.Project;
import com.abak.service.IQuotationService;
import com.abak.utility.AbakConstant;
import com.abak.utility.ApplicationContextProvider;
import com.abak.utility.ApplicationSession;
import com.abak.utility.EmailSend;
import com.abak.utility.GeneralUtility;
import com.abak.utility.JasperReportUtility;
import com.lowagie.text.pdf.PdfDocument;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/quotation")
public class QuotationController {
	
	private static final Logger LOGGER = Logger.getLogger(QuotationController.class);
	
	
	@Autowired
	private IQuotationService quotationService;
	
	@Autowired
	private JasperReportUtility jasperReportUtility;
	
	@Autowired
	private EmailSend emailSend;
	
	//ApplicationSession appSession = ApplicationSession.getInstance();

	@RequestMapping(params="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("quotationIndex");
		List<QuotationGrid> quotationGridList = quotationService.getQuotationGrid();
		modelAndView.addObject("gridlist", quotationGridList);
		return modelAndView;
		
	}
	
	
	
	@RequestMapping(params="newQuotationPopUp",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getNewQuotationPopUp() {
		
		ModelAndView modelAndView = new ModelAndView("quotationPopUp");
		 
		return modelAndView;
		
	}
	
	@Transactional
	@RequestMapping(params="generateQuotation",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String generateQuotation(@RequestParam String projectId,HttpServletRequest httpServletRequest) {
		
		
		String applicationFilePath = httpServletRequest.getRealPath("/");
		String responce ;
		
		try {
			
			LOGGER.info("Report running...");
			
			Project project = quotationService.getProjectById(Integer.valueOf(projectId));
			List<QuotationReportDTO> dataCollection = new ArrayList<QuotationReportDTO>();
			dataCollection = quotationService.prepareQuotationReportDTO(Integer.valueOf(projectId));
			
			String jrxmlFileLocation = applicationFilePath + AbakConstant.JasperReport + "\\quotationReport.jrxml";
			String subReportSource = applicationFilePath + AbakConstant.JasperReport+"\\";
			String reportLocation = "C:\\report\\"+projectId;

			//This is subreport linking
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(AbakConstant.SUBReportDIR, subReportSource);
			
			
			
			String filename=project.getProjectName()+"_"+projectId + GeneralUtility.getTime(new Date()) + AbakConstant.DOCXExtention;
			filename = filename.replaceAll(" ", "");
			
			jasperReportUtility.createReportInPDF(jrxmlFileLocation, map, dataCollection, reportLocation, filename);
			String destination=reportLocation+"\\"+filename;		 
			//emailSend.SendEmail("rajeshchavanrc08@gmail.com", "", "Testing Quotation", "", destination);
			responce = ApplicationSession.getInstance().getMessage("report.Responce.okMsg");
			
			LOGGER.info(filename + " has been generated Succesfully...");
			LOGGER.debug(filename + " has been generated Succesfully...");
			
		} catch (Exception e) {
			 
			e.printStackTrace();
			responce = ApplicationSession.getInstance().getMessage("report.Responce.errorMsg");
		}
	 
		return  responce; 
	}
	
	
	
	
}
