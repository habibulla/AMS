/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Logout;

import com.myapp.struts.Receipt.ReceiptDAO;
import com.myapp.struts.Receipt.ReceiptForm;
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
public class LogoutAction extends DispatchAction{
    
     public ActionForward logout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

  HttpSession session = request.getSession(false);
  session.invalidate();
        return mapping.findForward("display");

    }

}
