/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Settings;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Kaushi
 */
public class SettingsForm extends ActionForm {

    private String userName, userID, password, newPassword, cpassWord,message="",messagePassword="",currentPassword;
    private boolean active = false, admin = false;
    private List vehicleTypes = new ArrayList();
    private String selectedVehicleType = "";
    private String vehicleRemarks = "";
    private String vehicleDescriptions = "";
    private String txtVehicleName = "";
    private String otherChargeType = "";
    private String name = "";
    private String address = "";
    private String remarks = "";
    private int mobileNo = 0, contactID = 0;
    private String emailID = "";
    private String createdDate = "";
    private String txtRemarks = "";

    public SettingsForm() {
    }

    
    
    
    
    public String getCpassWord() {
        return cpassWord;
    }

    public void setCpassWord(String cpassWord) {
        this.cpassWord = cpassWord;
    }

    public String getTxtVehicleName() {
        return txtVehicleName;
    }

    public void setTxtVehicleName(String txtVehicleName) {
        this.txtVehicleName = txtVehicleName;
    }

    public String getTxtRemarks() {
        return txtRemarks;
    }

    public void setTxtRemarks(String txtRemarks) {
        this.txtRemarks = txtRemarks;
    }

    public String getSelectedVehicleType() {
        return selectedVehicleType;
    }

    public void setSelectedVehicleType(String selectedVehicleType) {
        this.selectedVehicleType = selectedVehicleType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public String getVehicleDescriptions() {
        return vehicleDescriptions;
    }

    public void setVehicleDescriptions(String vehicleDescriptions) {
        this.vehicleDescriptions = vehicleDescriptions;
    }

    public String getVehicleRemarks() {
        return vehicleRemarks;
    }

    public void setVehicleRemarks(String vehicleRemarks) {
        this.vehicleRemarks = vehicleRemarks;
    }

    public String getOtherChargeType() {
        return otherChargeType;
    }

    public void setOtherChargeType(String otherChargeType) {
        this.otherChargeType = otherChargeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessagePassword() {
        return messagePassword;
    }

    public void setMessagePassword(String messagePassword) {
        this.messagePassword = messagePassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    
    
    
}
