/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.web;

import com.myapp.struts.Invoice.*;
import com.myapp.struts.Login.UserInfo;
import com.myapp.struts.Settings.SettingsDao;
import com.myapp.struts.Settings.SettingsForm;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.OriginalNumToLetter;
import com.myapp.struts.booking.BookingAction;
import com.myapp.struts.booking.BookingForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class WebAction extends DispatchAction {

    public ActionForward pageload(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        new webForm();
        webForm webForm = (webForm) form;
        WebDAO dao = new WebDAO();
        dao.fillVehicle(webForm);

//        dao.fillInvoiceNo(webForm);
//        webForm.chargeDetailsList.clear();
//        invoiceForm.invoiceList.clear();
//        ArrayList states = (ArrayList) context.getAttribute("states");
//        ArrayList newStates = new ArrayList();
//        String responseText = "";
//        sending response text in the format label:value||label;value
//        for (int i = 0; i < webForm.getVehicles().size(); i++) {
//            DropDownFill temp = (DropDownFill) webForm.getVehicles().get(i);
//            responseText = temp.getId() + ";" + temp.getId() + "||" + responseText;
//        }
//        if (responseText.endsWith("||")) //chop off the ending ||
//        {
//            responseText = responseText.substring(0, responseText.lastIndexOf("||"));
//        }
//        PrintWriter out = response.getWriter();
//        out.println(responseText);
//        Close the writer
//        out.close();
        clear(mapping, form, request, response);
        return mapping.findForward("display");

    }

    public ActionForward checkForUserName(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        webForm settingsForm = (webForm) form;

        SettingsDao dao = new SettingsDao();
        settingsForm.setMessage("");
        if (dao.checkForUserName(settingsForm.getUserName())) {
            settingsForm.setMessage("!! Oops User Name already exists in database please select different...");
            settingsForm.setUserName("");
        } else {
            settingsForm.setMessage("");
        }
        return mapping.findForward("display");

    }

    public ActionForward saveUserDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        webForm settingsForm = (webForm) form;
        HttpSession session = request.getSession(false);
        WebDAO dao = new WebDAO();
        UserInfo user = new UserInfo();
        user.setUserName(settingsForm.getUserName());
        user.setAdminFlag(false);
  

        int contactid = dao.insertUserDetails(settingsForm);
        settingsForm.setName("");
        settingsForm.setUserName("");
        settingsForm.setCpassWord("");
//        settingsForm.setAdmin(false);
        settingsForm.setAddress("");
        settingsForm.setContactno(0);
        settingsForm.setEmail("");
//        settingsForm.set("");
        settingsForm.setPassword("");

        user.setContactId(contactid);
        session.setAttribute("user", user);
        session.setAttribute("contactid", contactid);

        request.setAttribute("messageUsercreation", "messageUsercreation");
        BookingAction webaction=new BookingAction();
        webaction.initialDisplay(mapping,new BookingForm(),request,response);
        return mapping.findForward("booking");
    }

    public ActionForward OK(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {

        InvoiceForm invoiceForm = (InvoiceForm) form;
        WebDAO dao = new WebDAO();
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
        WebDAO dao = new WebDAO();
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
        WebDAO dao = new WebDAO();
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
        WebDAO dao = new WebDAO();
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
        WebDAO dao = new WebDAO();
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
//        invoiceForm.chargeDetailsList.clear();
//        invoiceForm.invoiceList.clear();
        invoiceForm.setMaxInvoiceID(invoiceForm.getInvoiceNoR());
        request.setAttribute("invoiceNoMessage", "invoiceNoMessage");
        invoiceForm.setAmountInWords("");
        request.setAttribute("printButton", "printButton");
        return mapping.findForward("display");

    }

    public ActionForward printInvoice(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {

//        webForm invoiceForm = (webForm) form;
//        invoiceForm.setMaxInvoiceID(invoiceForm.getInvoiceNoR());
//        WebDAO dao = new WebDAO();
//        dao.fillVehicle(invoiceForm);
//        dao.fillOtherCharge(invoiceForm);
////        dao.fillInvoiceNo(invoiceForm);
//        dao.printFirstPart(invoiceForm);
//        dao.printSecondPart(invoiceForm);
//        dao.printThridPart(invoiceForm);
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
//        invoiceForm.chargeDetailsList.clear();
//        invoiceForm.invoiceList.clear();

        return mapping.findForward("display");

    }
}
