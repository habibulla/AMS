/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Lenovo
 */
public class BookingForm extends ActionForm {

    private String name,UserName,cpassWord,password;
    private String contactno;
    private String email;
    private String address;
    private Date fromdate=new Date();
    private Date todate=new Date();
    private String fromlocation;
    private String tolocation,description,path,pickuptime;
    private int vehicletypeid;
    private double amount;
    private int checkedVehicle=0,triptypesid=0,selecteddirection=0,selectedFromlocation=0,selectedtolocation=0;
    private String username;
    private List vehicles=new ArrayList();
    private List triptypes=new ArrayList();
    private List direction=new ArrayList();
    private List toLocations=new ArrayList();
    private List fromLocations=new ArrayList();

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    
    
    
    public String getPickuptime() {
        return pickuptime;
    }

    public void setPickuptime(String pickuptime) {
        this.pickuptime = pickuptime;
    }

    public int getSelectedFromlocation() {
        return selectedFromlocation;
    }

    public void setSelectedFromlocation(int selectedFromlocation) {
        this.selectedFromlocation = selectedFromlocation;
    }

    public int getSelectedtolocation() {
        return selectedtolocation;
    }

    public void setSelectedtolocation(int selectedtolocation) {
        this.selectedtolocation = selectedtolocation;
    }

    

    
    
    public List getToLocations() {
        return toLocations;
    }

    public void setToLocations(List toLocations) {
        this.toLocations = toLocations;
    }

    public List getFromLocations() {
        return fromLocations;
    }

    public void setFromLocations(List fromLocations) {
        this.fromLocations = fromLocations;
    }

    public String getCpassWord() {
        return cpassWord;
    }

    public void setCpassWord(String cpassWord) {
        this.cpassWord = cpassWord;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  

    
    
    public int getSelecteddirection() {
        return selecteddirection;
    }

    public void setSelecteddirection(int selecteddirection) {
        this.selecteddirection = selecteddirection;
    }

    public List getDirection() {
        return direction;
    }

    public void setDirection(List direction) {
        this.direction = direction;
    }
    
    
    

    public int getTriptypesid() {
        return triptypesid;
    }

    public void setTriptypesid(int triptypesid) {
        this.triptypesid = triptypesid;
    }

    
    
    
    public List getTriptypes() {
        return triptypes;
    }

    public void setTriptypes(List triptypes) {
        this.triptypes = triptypes;
    }

    public int getCheckedVehicle() {
        return checkedVehicle;
    }

    public void setCheckedVehicle(int checkedVehicle) {
        this.checkedVehicle = checkedVehicle;
    }

    public List getVehicles() {
        return vehicles;
    }

    public void setVehicles(List vehicles) {
        this.vehicles = vehicles;
    }

     
     
     
     
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getVehicletypeid() {
        return vehicletypeid;
    }

    public void setVehicletypeid(int vehicletypeid) {
        this.vehicletypeid = vehicletypeid;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public String getTolocation() {
        return tolocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
