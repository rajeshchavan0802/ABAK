package com.abak.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuotationReportDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String refNumber;
    private  String date;
    private  String to;
    private  String kindAttn;
    private  String subject;
    private  String yourRef;
    private  String construction;
    private  String system;
    private  String painting;
    private  String busbar;
    private  String earthing;
    private  String wiring;
    private  String totalAmt;
    private  String notes;
    private  String header;
    
    

    private List<QuotationReportSubReport1DTO> quotationReportSubReport1DTO = new ArrayList<>();
    private List<QuotationReportSubReport2DTO> quotationReportSubReport2DTO = new ArrayList<>();
    private List<QuotationReportSubReport3DTO> quotationReportSubReport3DTO = new ArrayList<>();


    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getKindAttn() {
        return kindAttn;
    }

    public void setKindAttn(String kindAttn) {
        this.kindAttn = kindAttn;
    }

    
    public String getYourRef() {
        return yourRef;
    }

    public void setYourRef(String yourRef) {
        this.yourRef = yourRef;
    }
 

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting;
    }

    public String getBusbar() {
        return busbar;
    }

    public void setBusbar(String busbar) {
        this.busbar = busbar;
    }

    public String getEarthing() {
        return earthing;
    }

    public void setEarthing(String earthing) {
        this.earthing = earthing;
    }

    public String getWiring() {
        return wiring;
    }

    public void setWiring(String wiring) {
        this.wiring = wiring;
    }

    

    public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<QuotationReportSubReport1DTO> getQuotationReportSubReport1DTO() {
        return quotationReportSubReport1DTO;
    }

    public void setQuotationReportSubReport1DTO(List<QuotationReportSubReport1DTO> quotationReportSubReport1DTO) {
        this.quotationReportSubReport1DTO = quotationReportSubReport1DTO;
    }

    public List<QuotationReportSubReport2DTO> getQuotationReportSubReport2DTO() {
        return quotationReportSubReport2DTO;
    }

    public void setQuotationReportSubReport2DTO(List<QuotationReportSubReport2DTO> quotationReportSubReport2DTO) {
        this.quotationReportSubReport2DTO = quotationReportSubReport2DTO;
    }

    public List<QuotationReportSubReport3DTO> getQuotationReportSubReport3DTO() {
        return quotationReportSubReport3DTO;
    }

    public void setQuotationReportSubReport3DTO(List<QuotationReportSubReport3DTO> quotationReportSubReport3DTO) {
        this.quotationReportSubReport3DTO = quotationReportSubReport3DTO;
    }

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
     
}
