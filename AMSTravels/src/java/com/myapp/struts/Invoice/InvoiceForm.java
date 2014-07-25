/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author prakash
 */
public class InvoiceForm extends ActionForm {

    private String invoiceDate = null;
    private int rowIDOtherCharge=0;
    private String customerName = "";
    private String description = "";
    private String mobileNo = "";
    private String emailID = "";
    private String address = "";
    private String startDate = null;
    private String endDate = null;
    private int checkedVehicle=0;
    private List vehicles=new ArrayList();
    private String vehicleNo;
    private float km=0;
    private float rate=0;
    private int amount=0;
    private int rowID=0;
    private int selectedOtherCharge=0;
    private List otherCharges=new ArrayList();
    private int otherChargeAmount=0;
    private String message="";
    private String visitPlace="";
    private int invoiceNo;
    
    private String amountInWords="";
    private float serviceTax=0;
    private int grandTotal=0,invoiceNoR;
    
    private int maxInvoiceID=0;
     private String customerNameR = "";
    private String addressR = "";
    private String mobileNoR;
    private String descriptionR = "", invoiceDateR = "",amountInWordsR="";
    private int grandTotalR;
    ArrayList<InvoiceData> invoiceListR = new ArrayList<InvoiceData>();
    ArrayList<ChargeData> chargeDetailsListR = new ArrayList<ChargeData>();

    public int getMaxInvoiceID() {
        return maxInvoiceID;
    }

    public void setMaxInvoiceID(int maxInvoiceID) {
        this.maxInvoiceID = maxInvoiceID;
    }


    
    
    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getOtherChargeAmount() {
        return otherChargeAmount;
    }

    public void setOtherChargeAmount(int otherChargeAmount) {
        this.otherChargeAmount = otherChargeAmount;
    }

    
    
    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    

    public float getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(float serviceTax) {
        this.serviceTax = serviceTax;
    }

    
    
    
    public int getRowIDOtherCharge() {
        return rowIDOtherCharge;
    }

    public void setRowIDOtherCharge(int rowIDOtherCharge) {
        this.rowIDOtherCharge = rowIDOtherCharge;
    }

    
    
    public String getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(String visitPlace) {
        this.visitPlace = visitPlace;
    }
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
    public List getVehicles() {
        return vehicles;
    }

    public void setVehicles(List vehicles) {
        this.vehicles = vehicles;
    }

    
    
    public int getCheckedVehicle() {
        return checkedVehicle;
    }

    public void setCheckedVehicle(int checkedVehicle) {
        this.checkedVehicle = checkedVehicle;
    }

    
    

    public List getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(List otherCharges) {
        this.otherCharges = otherCharges;
    }

    public int getSelectedOtherCharge() {
        return selectedOtherCharge;
    }

    public void setSelectedOtherCharge(int selectedOtherCharge) {
        this.selectedOtherCharge = selectedOtherCharge;
    }



    ArrayList<InvoiceData> invoiceList=new ArrayList<InvoiceData>(); 
    ArrayList<ChargeData> chargeDetailsList=new ArrayList<ChargeData>();

    public ArrayList<ChargeData> getChargeDetailsList() {
        return chargeDetailsList;
    }

    public void setChargeDetailsList(ArrayList<ChargeData> chargeDetailsList) {
        this.chargeDetailsList = chargeDetailsList;
    }
    


    public ArrayList<InvoiceData> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<InvoiceData> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

  



   
    

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public int getInvoiceNoR() {
        return invoiceNoR;
    }

    public void setInvoiceNoR(int invoiceNoR) {
        this.invoiceNoR = invoiceNoR;
    }

    public String getMobileNoR() {
        return mobileNoR;
    }

    public void setMobileNoR(String mobileNoR) {
        this.mobileNoR = mobileNoR;
    }

    
    
}
