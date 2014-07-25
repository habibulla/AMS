/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Receipt;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author prakash
 */
public class ReceiptForm extends ActionForm {

    private List invoiceNumbers = new ArrayList();
    private List paymentMode = new ArrayList();
    private List paymentType = new ArrayList();
    private int selectedPaymentMode = 0;
    private int selectedPaymentType = 0;
    private String receiptDate = "", customerName = "", vehicle = "", remarks = "", amountWords = "", invoiceDate = "";
    ;
    private int receiptNo = 0, invoiceNo = 0;
    private int amount = 0;
    private boolean checkApproved = false;
    //Reports
    private int rno;
    private int ino;
    private String rdate = "";
    private String idate = "";
    private String cname = "", rremarks = "";
    private String vehicleDetail = "", ramountInWord = "";
    private double ramount = 0.0;
    
    private String receiptPaymentMode="";
    private String receiptPaymentType="";

    
    
    
    private int receiptNoR;
    private String receiptDateR="";
    private String customerNameR="";
    private String amountInWordsR="";
    private String vehicleR="";
    private String paymentModeR="";
    private String paymentTypeR="";
    private int amountR;

    public String getAmountInWordsR() {
        return amountInWordsR;
    }

    public void setAmountInWordsR(String amountInWordsR) {
        this.amountInWordsR = amountInWordsR;
    }

    public int getAmountR() {
        return amountR;
    }

    public void setAmountR(int amountR) {
        this.amountR = amountR;
    }

    public String getCustomerNameR() {
        return customerNameR;
    }

    public void setCustomerNameR(String customerNameR) {
        this.customerNameR = customerNameR;
    }

    public String getPaymentModeR() {
        return paymentModeR;
    }

    public void setPaymentModeR(String paymentModeR) {
        this.paymentModeR = paymentModeR;
    }

    public String getPaymentTypeR() {
        return paymentTypeR;
    }

    public void setPaymentTypeR(String paymentTypeR) {
        this.paymentTypeR = paymentTypeR;
    }

    public String getReceiptDateR() {
        return receiptDateR;
    }

    public void setReceiptDateR(String receiptDateR) {
        this.receiptDateR = receiptDateR;
    }

    public int getReceiptNoR() {
        return receiptNoR;
    }

    public void setReceiptNoR(int receiptNoR) {
        this.receiptNoR = receiptNoR;
    }

    public String getVehicleR() {
        return vehicleR;
    }

    public void setVehicleR(String vehicleR) {
        this.vehicleR = vehicleR;
    }
    
    
    
    public String getReceiptPaymentMode() {
        return receiptPaymentMode;
    }

    public void setReceiptPaymentMode(String receiptPaymentMode) {
        this.receiptPaymentMode = receiptPaymentMode;
    }

    public String getReceiptPaymentType() {
        return receiptPaymentType;
    }

    public void setReceiptPaymentType(String receiptPaymentType) {
        this.receiptPaymentType = receiptPaymentType;
    }

    
    
    public List getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(List paymentMode) {
        this.paymentMode = paymentMode;
    }

    public List getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(List paymentType) {
        this.paymentType = paymentType;
    }

    public int getSelectedPaymentMode() {
        return selectedPaymentMode;
    }

    public void setSelectedPaymentMode(int selectedPaymentMode) {
        this.selectedPaymentMode = selectedPaymentMode;
    }

    public int getSelectedPaymentType() {
        return selectedPaymentType;
    }

    public void setSelectedPaymentType(int selectedPaymentType) {
        this.selectedPaymentType = selectedPaymentType;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getIdate() {
        return idate;
    }

    public void setIdate(String idate) {
        this.idate = idate;
    }

    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public double getRamount() {
        return ramount;
    }

    public void setRamount(double ramount) {
        this.ramount = ramount;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getVehicleDetail() {
        return vehicleDetail;
    }

    public void setVehicleDetail(String vehicleDetail) {
        this.vehicleDetail = vehicleDetail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getAmountWords() {
        return amountWords;
    }

    public void setAmountWords(String amountWords) {
        this.amountWords = amountWords;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public List getInvoiceNumbers() {
        return invoiceNumbers;
    }

    public void setInvoiceNumbers(List invoiceNumbers) {
        this.invoiceNumbers = invoiceNumbers;
    }

    public boolean isCheckApproved() {
        return checkApproved;
    }

    public void setCheckApproved(boolean checkApproved) {
        this.checkApproved = checkApproved;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getRremarks() {
        return rremarks;
    }

    public void setRremarks(String rremarks) {
        this.rremarks = rremarks;
    }

    public String getRamountInWord() {
        return ramountInWord;
    }

    public void setRamountInWord(String ramountInWord) {
        this.ramountInWord = ramountInWord;
    }
}
