package com.abak.dto;

import java.util.ArrayList;
import java.util.List;

public class QuotationReportSubReport3DTO {
    public String panelName;
    public List<QuotationReportSubReport3ChildDTO> quotationReportSubReport3ChildDTOS = new ArrayList<>();

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public List<QuotationReportSubReport3ChildDTO> getQuotationReportSubReport3ChildDTOS() {
        return quotationReportSubReport3ChildDTOS;
    }

    public void setQuotationReportSubReport3ChildDTOS(List<QuotationReportSubReport3ChildDTO> quotationReportSubReport3ChildDTOS) {
        this.quotationReportSubReport3ChildDTOS = quotationReportSubReport3ChildDTOS;
    }
}
