/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Settings;

import com.myapp.struts.Login.LoginDao;
import com.myapp.struts.Login.LoginForm;
import com.myapp.struts.Login.UserInfo;
import com.myapp.struts.Utility.mailsending;
import java.io.IOException;
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
 * @author Kaushi
 */
public class SettingsAction extends DispatchAction {

    public ActionForward displaySettings(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("display");
    }

    public ActionForward saveVehicleTypes(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SettingsForm settingsForm = (SettingsForm) form;
        SettingsDao dao = new SettingsDao();
        dao.insertVehicle(settingsForm.getTxtVehicleName(), settingsForm.getTxtRemarks());
        settingsForm.setTxtVehicleName("");
        settingsForm.setTxtRemarks("");
        request.setAttribute("messagevehicletype","messagevehicletype");
        return mapping.findForward("display");
    }

    public ActionForward saveOtherCharge(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SettingsForm settingsForm = (SettingsForm) form;
        SettingsDao dao = new SettingsDao();
        dao.insertOtherChargeTypes(settingsForm.getOtherChargeType());
        settingsForm.setOtherChargeType("");
        request.setAttribute("messageOtherCharge","messageOtherCharge");
        return mapping.findForward("display");
    }

    public ActionForward saveUserDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SettingsForm settingsForm = (SettingsForm) form;
        SettingsDao dao = new SettingsDao();
        dao.insertUserDetails(settingsForm);
        settingsForm.setName("");
        settingsForm.setUserName("");
        settingsForm.setCpassWord("");
        settingsForm.setAdmin(false);
        settingsForm.setAddress("");
        settingsForm.setMobileNo(0);
        settingsForm.setEmailID("");
        settingsForm.setRemarks("");
        settingsForm.setPassword("");
        request.setAttribute("messageUsercreation", "messageUsercreation");
        return mapping.findForward("display");
    }

    public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SettingsForm settingsForm = (SettingsForm) form;
        HttpSession session = request.getSession();
        UserInfo userId = (UserInfo) session.getAttribute("user");
        SettingsDao dao = new SettingsDao();
        dao.updatePassword(userId.getUserName(), settingsForm.getNewPassword());
        settingsForm.setNewPassword("");
        settingsForm.setPassword("");
        settingsForm.setCurrentPassword("");
        request.setAttribute("messageChangePassword", "messageChangePassword");
        return mapping.findForward("display");

    }

    public ActionForward checkForUserName(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SettingsForm settingsForm = (SettingsForm) form;
        HttpSession session = request.getSession();
        UserInfo userId = (UserInfo) session.getAttribute("user");
        SettingsDao dao = new SettingsDao();
        settingsForm.setMessage("");
        if (dao.checkForUserName(settingsForm.getUserName())) {
            settingsForm.setMessage("!! Oops User Name already exists in database please select different...");
            settingsForm.setUserName("");
        }else{
        settingsForm.setMessage("");
        }
        return mapping.findForward("display");

    }

    public ActionForward checkForPassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SettingsForm settingsForm = (SettingsForm) form;
        HttpSession session = request.getSession();
        UserInfo userId = (UserInfo) session.getAttribute("user");
        SettingsDao dao = new SettingsDao();
        settingsForm.setMessagePassword("");
        if (!dao.checkForPassword(userId.getUserName(), settingsForm.getCurrentPassword())) {

            settingsForm.setMessagePassword("!!Oops Enter Current password");
            settingsForm.setCurrentPassword("");
        }
        return mapping.findForward("display");

    }
    
    
     public ActionForward databackup(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, InterruptedException {
        try{
         new mailsending().Backupdbtosql();
         new mailsending().sendMailWithAttachment("shy.developers@gmail.com","AMSbackup","C:/backup.sql", "test this");
        }catch(Exception e){
//        request.setAttribute("messageChangePassword", "");
        return mapping.findForward("display");
        }
        request.setAttribute("messageBackUp", "messageBackUp");
        return mapping.findForward("display");

    }
}
