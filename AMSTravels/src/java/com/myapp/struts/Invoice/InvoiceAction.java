/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Invoice;

import com.myapp.struts.Login.UserInfo;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.OriginalNumToLetter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author prakash
 */
public class InvoiceAction extends DispatchAction {
    
    public ActionForward displayInvoice(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        new InvoiceForm();
        InvoiceForm invoiceForm = (InvoiceForm) form;
        InvoiceDAO dao = new InvoiceDAO();
        dao.fillVehicle(invoiceForm);
        dao.fillOtherCharge(invoiceForm);
//        dao.fillInvoiceNo(invoiceForm);
        invoiceForm.chargeDetailsList.clear();
        invoiceForm.invoiceList.clear();
        
        clear(mapping, form, request, response);
        return mapping.findForward("display");
        
    }
    
    public ActionForward OK(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
        InvoiceForm invoiceForm = (InvoiceForm) form;
        InvoiceDAO dao = new InvoiceDAO();
        InvoiceData temp = new InvoiceData();
        temp.setFromDate(invoiceForm.getStartDate());
        temp.setToDate(invoiceForm.getEndDate());
        
        for (int i = 0; i < invoiceForm.getVehicles().size(); i++) {
            int vehicleId = ((DropDownFill) invoiceForm.getVehicles().get(i)).getId();
            if (vehicleId == invoiceForm.getCheckedVehicle()) {
                
                temp.setVehicle(((DropDownFill) invoiceForm.getVehicles().get(i)).getLabel());
                temp.setSelectedVehicleId(vehicleId);
                break;
                
            }
        }
        temp.setVehicleNo(invoiceForm.getVehicleNo());
        temp.setKm(invoiceForm.getKm());
        temp.setRate(invoiceForm.getRate());
        temp.setAmount(invoiceForm.getAmount());
        temp.setVisitPlace(invoiceForm.getVisitPlace());
        temp.setCustomerName(invoiceForm.getCustomerName());
        temp.setAddress(invoiceForm.getAddress());
        temp.setDescription(invoiceForm.getDescription());
        temp.setEmailId(invoiceForm.getEmailID());
        temp.setMobileNo(invoiceForm.getMobileNo());
        
        
        temp.setSelectedVehicleId(invoiceForm.getCheckedVehicle());
        
        
        invoiceForm.getInvoiceList().add(temp);
        invoiceForm.setStartDate("");
        invoiceForm.setEndDate("");
        invoiceForm.setCheckedVehicle(0);
        invoiceForm.setVehicleNo("");
        invoiceForm.setKm(0);
        invoiceForm.setRate(0);
        invoiceForm.setAmount(0);
        invoiceForm.setVisitPlace("");
//          invoiceForm.setInvoiceNo();
//            dao.inserttoContactInvoiceInvoiceDetails(invoiceForm,userId.getContactId());

//        invoiceForm.setGrandTotal(invoiceForm.getGrandTotal() + invoiceForm.getAmount());

        
        int totalAmnt = 0;
        for (int i = 0; i < invoiceForm.getChargeDetailsList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getChargeDetailsList().get(i).getOtherChargeAmount();
        }
        
        for (int i = 0; i < invoiceForm.getInvoiceList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getInvoiceList().get(i).getAmount();
        }
        
        invoiceForm.setGrandTotal(totalAmnt);
        OriginalNumToLetter oNumToLe = new OriginalNumToLetter();
        String amountsWord = oNumToLe.enterNumber(invoiceForm.getGrandTotal());
        invoiceForm.setAmountInWords(amountsWord);
        return mapping.findForward("display");
        
    }
    
    public ActionForward OKOthercharge(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        InvoiceForm invoiceForm = (InvoiceForm) form;
        InvoiceDAO dao = new InvoiceDAO();
        boolean flag = true;
        
        
        ChargeData temp = new ChargeData();
        
        
        
        
        for (int i = 0; i < invoiceForm.getOtherCharges().size(); i++) {
            int otherChargeId = ((DropDownFill) invoiceForm.getOtherCharges().get(i)).getId();
            if (otherChargeId == invoiceForm.getSelectedOtherCharge()) {
                
                temp.setOtherCharges(((DropDownFill) invoiceForm.getOtherCharges().get(i)).getLabel());
                temp.setRowIDOtherCharge(otherChargeId);
                break;
                
            }
        }
        
        temp.setOtherChargeAmount(invoiceForm.getOtherChargeAmount());
        
        
        
        invoiceForm.getChargeDetailsList().add(temp);
//        xml.append("<userType>" + invoiceForm.getChargeDetailsList() + "</userType>");
        int totalAmnt = 0;
        for (int i = 0; i < invoiceForm.getChargeDetailsList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getChargeDetailsList().get(i).getOtherChargeAmount();
        }
        
        for (int i = 0; i < invoiceForm.getInvoiceList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getInvoiceList().get(i).getAmount();
        }
//        response.setContentType("text/xml");
//        StringBuffer xml = new StringBuffer(4096);
//        response.setContentType("text/xml");
//        PrintWriter out = response.getWriter();
        
        
        
        
        invoiceForm.setGrandTotal(totalAmnt);
//        xml.append("<info>");
//        xml.append("<userType>" + invoiceForm.getGrandTotal() + "</userType>");
//           xml.append("</info>");
//        out.println(invoiceForm.getGrandTotal());
//        System.out.println("xml==" + xml);
//        out.flush();
        
        OriginalNumToLetter oNumToLe = new OriginalNumToLetter();
        String amountsWord = oNumToLe.enterNumber(invoiceForm.getGrandTotal());
        invoiceForm.setAmountInWords(amountsWord);
        invoiceForm.setMessage("");
        invoiceForm.setSelectedOtherCharge(0);
        invoiceForm.setOtherChargeAmount(0);

//        xml.append("<userType>" + invoiceForm.getAmountInWords() + "</userType>");
//            HttpSession session = request.getSession();
//            UserInfo userId = (UserInfo) session.getAttribute("user");

//            dao.inserttoContactInvoiceInvoiceDetails(invoiceForm,userId.getContactId());
        
     
         return mapping.findForward("display");
//        return null;
        
    }
    
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        InvoiceForm invoiceForm = (InvoiceForm) form;
        InvoiceDAO dao = new InvoiceDAO();
        for (int i = 0; i < invoiceForm.getInvoiceList().size(); i++) {
            if (invoiceForm.getVehicleNo().equalsIgnoreCase(invoiceForm.getInvoiceList().get(i).getVehicleNo())) {
                invoiceForm.getInvoiceList().remove(i);
                break;
                
            }
        }
        int totalAmnt = 0;
        for (int i = 0; i < invoiceForm.getChargeDetailsList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getChargeDetailsList().get(i).getOtherChargeAmount();
        }
        
        for (int i = 0; i < invoiceForm.getInvoiceList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getInvoiceList().get(i).getAmount();
        }
        
        invoiceForm.setGrandTotal(totalAmnt);
        OriginalNumToLetter oNumToLe = new OriginalNumToLetter();
        String amountsWord = oNumToLe.enterNumber(invoiceForm.getGrandTotal());
        invoiceForm.setAmountInWords(amountsWord);
        return mapping.findForward("display");
        
    }
    
    public ActionForward deleteOtherCharge(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        InvoiceForm invoiceForm = (InvoiceForm) form;
        InvoiceDAO dao = new InvoiceDAO();
        for (int i = 0; i < invoiceForm.getChargeDetailsList().size(); i++) {
            if (invoiceForm.getSelectedOtherCharge() == invoiceForm.getChargeDetailsList().get(i).getRowIDOtherCharge()) {
                invoiceForm.getChargeDetailsList().remove(i);
                break;
                
            }
        }
        int totalAmnt = 0;
        for (int i = 0; i < invoiceForm.getChargeDetailsList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getChargeDetailsList().get(i).getOtherChargeAmount();
        }
        
        for (int i = 0; i < invoiceForm.getInvoiceList().size(); i++) {
            totalAmnt = totalAmnt + invoiceForm.getInvoiceList().get(i).getAmount();
        }
        
        invoiceForm.setGrandTotal(totalAmnt);
        OriginalNumToLetter oNumToLe = new OriginalNumToLetter();
        String amountsWord = oNumToLe.enterNumber(invoiceForm.getGrandTotal());
        invoiceForm.setAmountInWords(amountsWord);
        return mapping.findForward("display");
        
    }
    
    public ActionForward saveInvoice(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
        InvoiceForm invoiceForm = (InvoiceForm) form;
        InvoiceDAO dao = new InvoiceDAO();
        HttpSession session = request.getSession();
        UserInfo userId = (UserInfo) session.getAttribute("user");
        dao.inserttoContactInvoiceInvoiceDetailsInvoiceOtherChargeDetails(invoiceForm, userId.getContactId());
        
        invoiceForm.setInvoiceDate("");
        invoiceForm.setCustomerName("");
        invoiceForm.setEmailID("");
        invoiceForm.setMobileNo("");
        invoiceForm.setAddress("");
        invoiceForm.setAddress("");
        invoiceForm.setDescription("");

        //Running Charge
        invoiceForm.setStartDate("");
        invoiceForm.setEndDate("");
        invoiceForm.setCheckedVehicle(0);
        invoiceForm.setVehicleNo("");
        invoiceForm.setKm(0);
        invoiceForm.setRate(0);
        invoiceForm.setAmount(0);
        invoiceForm.setVisitPlace("");

        //Other charge

        invoiceForm.setSelectedOtherCharge(0);
        invoiceForm.setOtherChargeAmount(0);
        invoiceForm.setServiceTax(0);

//          invoiceForm.setAmountInWords("");
        invoiceForm.setGrandTotal(0);
        invoiceForm.chargeDetailsList.clear();
        invoiceForm.invoiceList.clear();
        invoiceForm.setMaxInvoiceID(invoiceForm.getInvoiceNoR());
        request.setAttribute("invoiceNoMessage", "invoiceNoMessage");
        invoiceForm.setAmountInWords("");
        request.setAttribute("printButton", "printButton");
        return mapping.findForward("display");
        
    }
    
    public ActionForward printInvoice(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
        
        InvoiceForm invoiceForm = (InvoiceForm) form;
        invoiceForm.setMaxInvoiceID(invoiceForm.getInvoiceNoR());
        InvoiceDAO dao = new InvoiceDAO();
        dao.fillVehicle(invoiceForm);
        dao.fillOtherCharge(invoiceForm);
//        dao.fillInvoiceNo(invoiceForm);
        dao.printFirstPart(invoiceForm);
        dao.printSecondPart(invoiceForm);
        dao.printThridPart(invoiceForm);
        return mapping.findForward("print");
        
    }
    
    public ActionForward clear(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
        InvoiceForm invoiceForm = new InvoiceForm();
        invoiceForm.setInvoiceDate("");
        invoiceForm.setCustomerName("");
        invoiceForm.setEmailID("");
        invoiceForm.setMobileNo("");
        invoiceForm.setAddress("");
        invoiceForm.setAddress("");
        invoiceForm.setDescription("");

        //Running Charge
        invoiceForm.setStartDate("");
        invoiceForm.setEndDate("");
        invoiceForm.setCheckedVehicle(0);
        invoiceForm.setVehicleNo("");
        invoiceForm.setKm(0);
        invoiceForm.setRate(0);
        invoiceForm.setAmount(0);
        invoiceForm.setVisitPlace("");

        //Other charge

        invoiceForm.setSelectedOtherCharge(0);
        invoiceForm.setOtherChargeAmount(0);
        invoiceForm.setServiceTax(0);
        invoiceForm.setAmountInWords("");
        invoiceForm.setGrandTotal(0);
        invoiceForm.chargeDetailsList.clear();
        invoiceForm.invoiceList.clear();
        
        return mapping.findForward("display");
        
    }
}
