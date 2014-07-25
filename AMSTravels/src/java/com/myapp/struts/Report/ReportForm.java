/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Report;

import com.myapp.struts.Invoice.ChargeData;
import com.myapp.struts.Invoice.InvoiceData;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author prakash
 */
public class ReportForm extends ActionForm{
    
    
    private String fromeDate="",toDate="",receiptDateR,vehicleR,paymentTypeR,paymentModeR;
    private  List reportType= new ArrayList();
    private  List<ReportType_Bean> reportDetails= new ArrayList<ReportType_Bean>();
    private int selectedReport=0,receiptNoR,amountR;
    private int rowID=0,documentNo=0;

    
    
    
    
     private String customerNameR = "";
    private String addressR = "";
    private String mobileNoR;
    private String descriptionR = "", invoiceDateR = "",amountInWordsR="";
    private int grandTotalR,invoiceNoR;
    ArrayList<InvoiceData> invoiceListR = new ArrayList<InvoiceData>();
    ArrayList<ChargeData> chargeDetailsListR = new ArrayList<ChargeData>();

    public int getInvoiceNoR() {
        return invoiceNoR;
    }

    public void setInvoiceNoR(int invoiceNoR) {
        this.invoiceNoR = invoiceNoR;
    }

    
    
    public String getAddressR() {
        return addressR;
    }

    public void setAddressR(String addressR) {
        this.addressR = addressR;
    }

    public String getAmountInWordsR() {
        return amountInWordsR;
    }

    public void setAmountInWordsR(String amountInWordsR) {
        this.amountInWordsR = amountInWordsR;
    }

    public ArrayList<ChargeData> getChargeDetailsListR() {
        return chargeDetailsListR;
    }

    public void setChargeDetailsListR(ArrayList<ChargeData> chargeDetailsListR) {
        this.chargeDetailsListR = chargeDetailsListR;
    }

    public String getCustomerNameR() {
        return customerNameR;
    }

    public void setCustomerNameR(String customerNameR) {
        this.customerNameR = customerNameR;
    }

    public String getDescriptionR() {
        return descriptionR;
    }

    public void setDescriptionR(String descriptionR) {
        this.descriptionR = descriptionR;
    }

    public int getGrandTotalR() {
        return grandTotalR;
    }

    public void setGrandTotalR(int grandTotalR) {
        this.grandTotalR = grandTotalR;
    }

    public String getInvoiceDateR() {
        return invoiceDateR;
    }

    public void setInvoiceDateR(String invoiceDateR) {
        this.invoiceDateR = invoiceDateR;
    }

    public ArrayList<InvoiceData> getInvoiceListR() {
        return invoiceListR;
    }

    public void setInvoiceListR(ArrayList<InvoiceData> invoiceListR) {
        this.invoiceListR = invoiceListR;
    }

    public String getMobileNoR() {
        return mobileNoR;
    }

    public void setMobileNoR(String mobileNoR) {
        this.mobileNoR = mobileNoR;
    }
    
    
    public int getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(int documentNo) {
        this.documentNo = documentNo;
    }

    
    
    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    
    
    public ReportForm() {
    }

    public String getFromeDate() {
        return fromeDate;
    }

    public void setFromeDate(String fromeDate) {
        this.fromeDate = fromeDate;
    }

  

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public List getReportType() {
        return reportType;
    }

    public void setReportType(List reportType) {
        this.reportType = reportType;
    }

    public int getSelectedReport() {
        return selectedReport;
    }

    public void setSelectedReport(int selectedReport) {
        this.selectedReport = selectedReport;
    }

    public List<ReportType_Bean> getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(List<ReportType_Bean> reportDetails) {
        this.reportDetails = reportDetails;
    }

    public int getDocumentMo() {
        return documentNo;
    }

    public void setDocumentMo(int documentMo) {
        this.documentNo = documentMo;
    }

    public String getReceiptDateR() {
        return receiptDateR;
    }

    public void setReceiptDateR(String receiptDateR) {
        this.receiptDateR = receiptDateR;
    }

    public String getVehicleR() {
        return vehicleR;
    }

    public void setVehicleR(String vehicleR) {
        this.vehicleR = vehicleR;
    }

    public String getPaymentTypeR() {
        return paymentTypeR;
    }

    public void setPaymentTypeR(String paymentTypeR) {
        this.paymentTypeR = paymentTypeR;
    }

    public String getPaymentModeR() {
        return paymentModeR;
    }

    public void setPaymentModeR(String paymentModeR) {
        this.paymentModeR = paymentModeR;
    }

    public int getReceiptNoR() {
        return receiptNoR;
    }

    public void setReceiptNoR(int receiptNoR) {
        this.receiptNoR = receiptNoR;
    }

    public int getAmountR() {
        return amountR;
    }

    public void setAmountR(int amountR) {
        this.amountR = amountR;
    }

   
  
    

}
