/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Invoice;

/**
 *
 * @author prakash
 */
public class ChargeData {

    private int rowIDOtherCharge=0;
    private String otherCharges="";
    private int otherChargeAmount=0;

    public int getRowIDOtherCharge() {
        return rowIDOtherCharge;
    }

    public void setRowIDOtherCharge(int rowIDOtherCharge) {
        this.rowIDOtherCharge = rowIDOtherCharge;
    }

    public int getOtherChargeAmount() {
        return otherChargeAmount;
    }

    public void setOtherChargeAmount(int otherChargeAmount) {
        this.otherChargeAmount = otherChargeAmount;
    }

   

    
    
   

    public String getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(String otherCharges) {
        this.otherCharges = otherCharges;
    }



}
