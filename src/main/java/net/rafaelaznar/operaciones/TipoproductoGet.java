/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.operaciones;

/**
 *
 * @author rafa
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import net.rafaelaznar.bean.Tipoproducto;
import net.rafaelaznar.dao.TipoproductoDao;

public class TipoproductoGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                TipoproductoDao oTipoproductoDAO = new TipoproductoDao();                             
                Tipoproducto oTipoproducto=oTipoproductoDAO.get(Integer.parseInt(request.getParameter("id")));
                data = new Gson().toJson(oTipoproducto);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("TipoproductoGetJson: View Error: " + e.getMessage());
        }
    }
}