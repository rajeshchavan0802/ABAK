package com.abak.service;

import java.util.List;

import com.abak.dto.QuotationGrid;
import com.abak.dto.QuotationReportDTO;
import com.abak.entity.Project;
import org.springframework.web.bind.annotation.RequestParam;

public interface IQuotationService{
	
	public List<QuotationGrid> getQuotationGrid();

	public Project getProjectById(Integer projectId);

	public List<QuotationReportDTO> prepareQuotationReportDTO(Integer projectId);

}
