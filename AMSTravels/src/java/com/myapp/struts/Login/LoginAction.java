/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Kaushi
 */
public class LoginAction extends Action{

   public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        LoginForm loginForm = (LoginForm) form;
        LoginDao dao = new LoginDao();
        HttpSession session = request.getSession(false);
        UserInfo user = dao.validateForm(loginForm);
         loginForm.setMessage("");
        if (user == null) {
            loginForm.setMessage(loginForm.getUserName() + " is not a valid user");

          
            loginForm.setUserName("");
            loginForm.setPassword("");

            return mapping.findForward("failure");

        } else {
            session.setAttribute("user", user);
            session.setAttribute("userName", user.getUserName());
            loginForm.setPassword("");
            return mapping.findForward("display");
        }


    }

}
