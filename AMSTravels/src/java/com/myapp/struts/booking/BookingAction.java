/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.booking;

import com.myapp.struts.Invoice.*;
import com.myapp.struts.Login.UserInfo;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.OriginalNumToLetter;
import com.myapp.struts.web.WebDAO;
import com.myapp.struts.web.webForm;
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
public class BookingAction extends DispatchAction {
    
    
    

    public ActionForward initialDisplay(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        new BookingForm();
        BookingForm webForm = (BookingForm) form;
        BookingDAO dao = new BookingDAO();
        dao.fillVehicle(webForm);
        webForm.setTriptypesid(1);
        dao.filldirections(webForm);
//        clear(mapping, form, request, response);
        return mapping.findForward("display");
    }
    
    
     public ActionForward saveUserDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        BookingForm settingsForm = (BookingForm) form;
        HttpSession session = request.getSession(false);
        BookingDAO dao = new BookingDAO();
        UserInfo user = new UserInfo();
        user.setUserName(settingsForm.getUserName());
        user.setAdminFlag(false);
        int contactid = dao.insertUserDetails(settingsForm);
        settingsForm.setName("");
        settingsForm.setUserName("");
        settingsForm.setCpassWord("");
//        settingsForm.setAdmin(false);
        settingsForm.setAddress("");
        settingsForm.setContactno(0+"");
        settingsForm.setEmail("");
//        settingsForm.set("");
        settingsForm.setPassword("");

        user.setContactId(contactid);
        session.setAttribute("user", user);
        session.setAttribute("contactid", contactid);

        request.setAttribute("messageUsercreation", "messageUsercreation");
//        BookingAction webaction=new BookingAction();
        initialDisplay(mapping,new BookingForm(),request,response);
        return mapping.findForward("display");
    }
    
    public ActionForward initialDisplayforlocal(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        new BookingForm();
        BookingForm webForm = (BookingForm) form;
        BookingDAO dao = new BookingDAO();
        dao.fillVehicle(webForm);
        webForm.setTriptypesid(2);
        dao.filldirections(webForm);
        dao.fillLocationDetailsLocalNOutofstn(webForm,2);
        clear(mapping, form, request, response);
        return mapping.findForward("display");
    }
    
        public ActionForward initialDisplayforoutofstation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        new BookingForm();
        BookingForm webForm = (BookingForm) form;
        BookingDAO dao = new BookingDAO();
        dao.fillVehicle(webForm);
        webForm.setTriptypesid(3);
        dao.filldirections(webForm);
        dao.fillLocationDetailsLocalNOutofstn(webForm,3);
        clear(mapping, form, request, response);
        return mapping.findForward("display");
    }

    public ActionForward OK(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        InvoiceForm invoiceForm = (InvoiceForm) form;
        BookingDAO dao = new BookingDAO();
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

    public ActionForward getLocationDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        BookingForm bookingForm = (BookingForm) form;
        BookingDAO dao = new BookingDAO();
        boolean flag = true;

        dao.fillLocationDetails(bookingForm);

        return mapping.findForward("display");
//        return null;

    }

    public ActionForward getAmountDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookingForm bookingForm = (BookingForm) form;
        BookingDAO dao = new BookingDAO();
        boolean flag = true;

        dao.fillLocationDetails(bookingForm);

        return mapping.findForward("display");

    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        InvoiceForm invoiceForm = (InvoiceForm) form;
        BookingDAO dao = new BookingDAO();
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
        BookingDAO dao = new BookingDAO();
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
        BookingDAO dao = new BookingDAO();
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
