/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Utility;

/**
 *
 * @author prasanna
 */
public class DropDownFill {

    int id;
    String label;

    public DropDownFill(int id, String label) {
        this.id = id;
        this.label = label;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

   
}
