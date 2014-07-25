/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Receipt;

import com.myapp.struts.Login.UserInfo;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.OriginalNumToLetter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ReceiptAction extends DispatchAction {

    public ActionForward displayReceipt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ReceiptForm receiptForm = (ReceiptForm) form;
        ReceiptDAO dao = new ReceiptDAO();
        request.setAttribute("nonInvoice", "nonInvoice");
        request.setAttribute("report", "report");

        receiptForm.setAmount(0);
        receiptForm.setAmountWords("");
        receiptForm.setCustomerName("");
        receiptForm.setInvoiceDate("");
        receiptForm.setInvoiceNo(0);
        receiptForm.setSelectedPaymentMode(0);
        receiptForm.setSelectedPaymentType(0);
        receiptForm.setVehicle("");


        receiptForm.setRemarks("");
        dao.fillInvoiceNo(receiptForm);
        dao.fillPaymentMode(receiptForm);
        dao.fillPaymentType(receiptForm);
//        receiptForm.setReceiptNo(dao.getMaxReceiptID() + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        receiptForm.setReceiptDate(sdf.format(currentDate));
        return mapping.findForward("display");

    }

    public ActionForward fillReceiptDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ReceiptForm receiptForm = (ReceiptForm) form;
        ReceiptDAO dao = new ReceiptDAO();
        dao.FillDetails(receiptForm);
        request.setAttribute("nonInvoice", "nonInvoice");
//      
        return mapping.findForward("display");

    }

    public ActionForward Save(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {



        ReceiptForm receiptForm = (ReceiptForm) form;
        ReceiptDAO dao = new ReceiptDAO();

        HttpSession session = request.getSession();
        UserInfo userId = (UserInfo) session.getAttribute("user");
        OriginalNumToLetter oNumToLe = new OriginalNumToLetter();
        String amountsWord = oNumToLe.enterNumber(receiptForm.getAmount());
        receiptForm.setAmountWords(amountsWord);
        dao.insertToReceipt(receiptForm, userId.getContactId());
//        clear(mapping, form, request, response);
//        dao.Reportdetails(receiptForm);

        for (int i = 0; i < receiptForm.getPaymentMode().size(); i++) {
            int paymentModeID = ((DropDownFill) receiptForm.getPaymentMode().get(i)).getId();
            if (paymentModeID == receiptForm.getSelectedPaymentMode()) {

                receiptForm.setReceiptPaymentMode(((DropDownFill) receiptForm.getPaymentMode().get(i)).getLabel());

                break;

            }
        }

        for (int i = 0; i < receiptForm.getPaymentType().size(); i++) {
            int paymentTypeID = ((DropDownFill) receiptForm.getPaymentType().get(i)).getId();
            if (paymentTypeID == receiptForm.getSelectedPaymentType()) {

                receiptForm.setReceiptPaymentType(((DropDownFill) receiptForm.getPaymentType().get(i)).getLabel());

                break;

            }
        }
        dao.fillPaymentMode(receiptForm);
        dao.fillPaymentType(receiptForm);
        request.setAttribute("printButton", "printButton");
        receiptForm.setAmount(0);
        receiptForm.setAmountWords("");
        receiptForm.setCustomerName("");
        receiptForm.setInvoiceDate("");
        receiptForm.setInvoiceNo(0);
        receiptForm.setSelectedPaymentMode(0);
        receiptForm.setSelectedPaymentType(0);
        receiptForm.setVehicle("");


        receiptForm.setRemarks("");
        return mapping.findForward("display");

    }

    public ActionForward clear(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ReceiptForm receiptForm = (ReceiptForm) form;

        receiptForm.setAmount(0);
        receiptForm.setAmountWords("");
        receiptForm.setCustomerName("");
        receiptForm.setInvoiceDate("");
        receiptForm.setInvoiceNo(0);
        receiptForm.setReceiptNo(0);
        receiptForm.setVehicle("");

        receiptForm.setReceiptDate("");
        receiptForm.setRemarks("");
        return mapping.findForward("display");

    }

    public ActionForward printReceipt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ReceiptForm receiptForm = (ReceiptForm) form;
        ReceiptDAO dao = new ReceiptDAO();
        dao.printTheReceipt(receiptForm);

        return mapping.findForward("print");

    }
}
