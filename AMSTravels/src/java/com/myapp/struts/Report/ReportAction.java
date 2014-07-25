/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Report;

import com.myapp.struts.Receipt.ReceiptDAO;
import com.myapp.struts.Receipt.ReceiptForm;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.stringconstant;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.LookupDispatchAction;

/**
 *
 * @author prakash
 */
public class ReportAction extends DispatchAction {

//    @Override
//    protected Map getKeyMethodMap() {
//        Map map = new HashMap();
//        map.put("com.myapp.struts.Report.displayReport", "displayReport");
//
//        return map;
//    }
    public ActionForward displayReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ReportForm reportForm = (ReportForm) form;
//        ReportDAO dao = new ReportDAO();
        List<DropDownFill> lstReportType = new ArrayList<DropDownFill>();
        lstReportType.add(new DropDownFill(0, stringconstant.shySelect));
        lstReportType.add(new DropDownFill(1, stringconstant.shyReceipt));
        lstReportType.add(new DropDownFill(2, stringconstant.shyInvoice));
        reportForm.setReportType(lstReportType);
        reportForm.getReportDetails().clear();
        reportForm.setSelectedReport(0);
        reportForm.setToDate("");
        reportForm.setFromeDate("");

        return mapping.findForward("display");

    }

    public ActionForward clearList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ReportForm reportForm = (ReportForm) form;

        reportForm.getReportDetails().clear();

        return mapping.findForward("display");

    }

    public ActionForward searchreportdetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ReportForm reportForm = (ReportForm) form;
        ReportDAO dao = new ReportDAO();
        reportForm.getReportDetails().clear();
        for (int i = 0; i < reportForm.getReportType().size(); i++) {
            int reportyId = ((DropDownFill) reportForm.getReportType().get(i)).getId();
            if (reportyId == reportForm.getSelectedReport()) {
                dao.searchreportdetails(reportForm, ((DropDownFill) reportForm.getReportType().get(reportyId)).getLabel(), reportForm.getFromeDate(), reportForm.getToDate());
            }
        }
        List<DropDownFill> lstReportType = new ArrayList<DropDownFill>();
        lstReportType.add(new DropDownFill(0, stringconstant.shySelect));
        lstReportType.add(new DropDownFill(1, stringconstant.shyReceipt));
        lstReportType.add(new DropDownFill(2, stringconstant.shyInvoice));
        reportForm.setReportType(lstReportType);
        if (reportForm.getReportDetails().size() <= 0) {
        }

        return mapping.findForward("display");

    }

    public ActionForward deleterow(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ReportForm reportForm = (ReportForm) form;
        ReportDAO dao = new ReportDAO();

        for (int k = 0; k < reportForm.getReportDetails().size(); k++) {
            if (reportForm.getReportDetails().get(k).getDocumentNo() == reportForm.getDocumentMo()) {
                for (int i = 0; i < reportForm.getReportType().size(); i++) {
                    int reportyId = ((DropDownFill) reportForm.getReportType().get(i)).getId();
                    if (reportyId == reportForm.getSelectedReport()) {
                        dao.updateCancelled(((DropDownFill) reportForm.getReportType().get(reportyId)).getLabel(), 1, reportForm.getReportDetails().get(k).getDocumentNo());

                        reportForm.getReportDetails().remove(k);
                    }
                }
                break;
            }
        }


        return mapping.findForward("display");

    }

    public ActionForward viewReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ReportForm reportForm = (ReportForm) form;
        ReportDAO dao = new ReportDAO();
        for (int i = 0; i < reportForm.getReportType().size(); i++) {
            int reportyId = ((DropDownFill) reportForm.getReportType().get(i)).getId();
            if (reportyId == reportForm.getSelectedReport()) {
                if (((DropDownFill) reportForm.getReportType().get(reportyId)).getLabel().equalsIgnoreCase(stringconstant.shyInvoice)) {
                    for (int k = 0; k < reportForm.getReportDetails().size(); k++) {
                        if (reportForm.getReportDetails().get(k).getDocumentNo() == reportForm.getDocumentMo()) {

                            dao.printFirstPart(reportForm, reportForm.getReportDetails().get(k).getDocumentNo());
                            dao.printSecondPart(reportForm, reportForm.getReportDetails().get(k).getDocumentNo());
                            dao.printThridPart(reportForm, reportForm.getReportDetails().get(k).getDocumentNo());
                            break;
                        }


                    }
                    return mapping.findForward("printInvoice");
                }
                if (((DropDownFill) reportForm.getReportType().get(reportyId)).getLabel().equalsIgnoreCase(stringconstant.shyReceipt)) {

                    for (int k = 0; k < reportForm.getReportDetails().size(); k++) {
                        if (reportForm.getReportDetails().get(k).getDocumentNo() == reportForm.getDocumentMo()) {

                            dao.printFirstPartforreceipt(reportForm, reportForm.getReportDetails().get(k).getDocumentNo());
                          
                            break;
                        }


                    }
                      return mapping.findForward("printReceipt");
                }
            }

        }


        return null;
    }
}
