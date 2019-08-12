package com.abak.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abak.dto.QuotationReportDTO;
import com.abak.dto.QuotationReportSubReport1DTO;
import com.abak.dto.QuotationReportSubReport2DTO;
import com.abak.dto.QuotationReportSubReport3ChildDTO;
import com.abak.dto.QuotationReportSubReport3DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abak.dao.IQuotationDAO;
import com.abak.dao.ISalesDAO;
import com.abak.dto.QuotationGrid;
import com.abak.entity.Panel;
import com.abak.entity.PanelDetails;
import com.abak.entity.Project;
@Service
public class QuotationService implements IQuotationService{

	@Autowired
	private IQuotationDAO quotationDAO;
	
	@Autowired
	private ISalesDAO salesDAO;
	
	@Override
	@Transactional
	public List<QuotationGrid> getQuotationGrid() {
		// TODO Auto-generated method stub
		List<Object[]> list = quotationDAO.getListForQuotationGrid();
		List<QuotationGrid>  gridList = new ArrayList<QuotationGrid>();
		
		QuotationGrid grid ;
		
		for(Object[] temp : list) {
			
			grid = new QuotationGrid();
			
			grid.setProjectId(temp[0]!=null ? Integer.valueOf(temp[0].toString()) : null);
			grid.setProjectName(temp[1]!=null ? temp[1].toString() : "");
			grid.setKindAttPersonEmail(temp[2]!=null ? temp[2].toString() : "");
			grid.setEnquiryNumber(temp[3]!=null ? Integer.valueOf(temp[3].toString()) : null);
			grid.setCustomerName(temp[4]!=null ? temp[4].toString() : "");
			grid.setIsQuotationPresent(temp[4]!=null ? Boolean.valueOf(temp[4].toString()) : null);
			
			gridList.add(grid);
			
		}
		
		
		return gridList;
	}
	
	
	
	@Override
	@Transactional
	public Project getProjectById(Integer projectId) {
		return salesDAO.getProjectById(projectId);
	}

	@Override
	public List<QuotationReportDTO> prepareQuotationReportDTO(Integer projectId){

		Project project = this.getProjectById(projectId);
		QuotationReportDTO reportDTO = new QuotationReportDTO();
		
		//Static Subreport DTO2
		List<QuotationReportSubReport2DTO> quotationReportSubReport2DTO = new ArrayList<QuotationReportSubReport2DTO>();
		quotationReportSubReport2DTO.add(new QuotationReportSubReport2DTO());
		reportDTO.setQuotationReportSubReport2DTO(quotationReportSubReport2DTO);
		
		

		reportDTO.setRefNumber("Ref. No: AEE/KLH/Q-823/2018-19.");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);
		reportDTO.setDate(strDate);
		
		reportDTO.setTo("M/s. K2 LIGHT HOUSE, MERCHANTS CENTER, SHOP NO. 8 &9, SECTOR-19, APMC MARKET, OPP. A GALI GATE, DANA BUNDER, VASHI, NAVIMUMBAI-400705. ");
		reportDTO.setKindAttn("Mr. KALPESH PATEL");
		reportDTO.setSubject("QUOTATION FOR SUPPLY OF ELECTRICAL PANELS FOR ALLAHABAD BANK, KALYAN PROJECT");
		reportDTO.setYourRef("YOUR ENQUIRY DATED 21 JANUARY 2019. ");
		
		reportDTO.setConstruction("The Panels will be fabricated with main structure 2mm CRCA sheet and Door partitions will be 2mm CRCA sheet.");
		reportDTO.setSystem("The panels will be Dust and Vermin Proof, 415V 3Ph 4wire, 50Hz, Wall Mounting, Indoor Type, Single Front, Non Draw-out Compartmentalize type as per IP-42 Construction. ");
		reportDTO.setPainting("The panels will be powder coated with Siemens Grey RAL-7032 with 7 Tank Process for cleaning & Phosphatising before powder coating. ");
		reportDTO.setBusbar("Copper/Aluminium Busbar with colour coded heat shrinkable sleeves, current density of bus bar 1.6A/1.3A/Sq.mm respectively Busbar shall be supported on high quality, nonflammable SMC/DMC Insulators.");
		reportDTO.setEarthing("Appropriate size of Copper /Aluminium earth Busbar running throughout the length of panel.");
		reportDTO.setWiring("All control, power and meter wiring will be done with approved make PVC insulated Copper Wire 1.1 Kv grade. The wires shall be identified by numbered ferrules at each end. All in accordance to the connection diagram. ");
		
		reportDTO.setNotes("");
		reportDTO.setHeader("C:\\Users\\Rajesh chavan\\git\\erpAbak\\src\\main\\webapp\\images\\quotationHeader.PNG");


		List<QuotationReportDTO> quotationReportDTOS = new ArrayList<>();
		quotationReportDTOS.add(reportDTO);
		
		List<QuotationReportSubReport1DTO> quotationReportSubReport1DTOs = new ArrayList<QuotationReportSubReport1DTO>();
		Double tatalAmtOfPanel=0D;
		
		List<QuotationReportSubReport3DTO> prepareQuotationReportSubReport3DTO = prepareQuotationReportSubReport3DTO(project.getPanels(),quotationReportSubReport1DTOs,tatalAmtOfPanel);
		reportDTO.setQuotationReportSubReport3DTO(prepareQuotationReportSubReport3DTO);


		reportDTO.setQuotationReportSubReport1DTO(quotationReportSubReport1DTOs);
		reportDTO.setTotalAmt(tatalAmtOfPanel.toString());
		
		return quotationReportDTOS;
	}
	
	
	public List<QuotationReportSubReport3DTO> prepareQuotationReportSubReport3DTO(List<Panel> panels,List<QuotationReportSubReport1DTO> quotationReportSubReport1DTOs,Double tatalAmtOfPanel){
		
		List<QuotationReportSubReport3DTO> report3dtos = new ArrayList<QuotationReportSubReport3DTO>();
		QuotationReportSubReport3DTO quotationReportSubReport3DTO =null;
		List<QuotationReportSubReport3ChildDTO> childDTOs=null;
		QuotationReportSubReport3ChildDTO childDTO=null;
		
		QuotationReportSubReport1DTO quotationReportSubReport1DTO = null;
		Integer countforDTO1 = 1;
		for(Panel panel : panels) {
			
			//setting DTO 1
			quotationReportSubReport1DTO = new QuotationReportSubReport1DTO();
			quotationReportSubReport1DTO.setSrNo(countforDTO1.toString());
			quotationReportSubReport1DTO.setDescription(panel.getPanelName()!=null? panel.getPanelName() : "");
			quotationReportSubReport1DTO.setQty(panel.getQuntity() != null ? panel.getQuntity().toString() : "");
			quotationReportSubReport1DTO.setUnitRate(panel.getUnitRate() != null? panel.getUnitRate().toString() : "");
			quotationReportSubReport1DTO.setTotal(panel.getNegotiatedPrice() != null ? panel.getNegotiatedPrice().toString() : "");
			tatalAmtOfPanel+=panel.getNegotiatedPrice();
			quotationReportSubReport1DTOs.add(quotationReportSubReport1DTO);
			countforDTO1++;
			
			
			//setting DTO 3
			quotationReportSubReport3DTO = new  QuotationReportSubReport3DTO();
			quotationReportSubReport3DTO.setPanelName(panel.getPanelName());
			
			
			childDTOs = new ArrayList<QuotationReportSubReport3ChildDTO>();
			Integer count = 1;
			
			for(PanelDetails details: panel.getPanelDetailses()) {
				
				childDTO = new QuotationReportSubReport3ChildDTO();
				
				childDTO.setSrNo(count.toString());
				childDTO.setDescription(details.getDescription()!=null ? details.getDescription():"");
				childDTO.setQty(details.getQuntity() != null? details.getQuntity().toString(): "");
				childDTO.setMake(details.getMake() != null ? details.getMake() : "");
				
				
				childDTOs.add(childDTO);
				count++;
				
			}
			
			quotationReportSubReport3DTO.setQuotationReportSubReport3ChildDTOS(childDTOs);
			report3dtos.add(quotationReportSubReport3DTO);
		}
		
		
		return report3dtos;
		
	}
	
	
	 
	

}
