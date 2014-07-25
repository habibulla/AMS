/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Lenovo
 */
public class webForm extends ActionForm {

    private String name;
    private int contactno;
    private String email;
    private String address;
    private Date fromdate=new Date();
    private Date todate=new Date();
    private String fromlocation;
    private String tolocation,description,path;
    private int vehicletypeid,selecteddirection;
    private double amount;
    private int checkedVehicle=0;
    private String userName,password,cpassWord,message;
    private List vehicles=new ArrayList();
    private List direction=new ArrayList();

    
    
    
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

    
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassWord() {
        return cpassWord;
    }

    public void setCpassWord(String cpassWord) {
        this.cpassWord = cpassWord;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getContactno() {
        return contactno;
    }

    public void setContactno(int contactno) {
        this.contactno = contactno;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
