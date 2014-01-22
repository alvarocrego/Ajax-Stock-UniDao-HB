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
import net.rafaelaznar.bean.Cliente;
import net.rafaelaznar.dao.ClienteDao;

public class ClienteGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                ClienteDao oClienteDAO = new ClienteDao();                             
                Cliente oCliente=oClienteDAO.get(Integer.parseInt(request.getParameter("id")));
                data = new Gson().toJson(oCliente);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("ClienteGetJson: View Error: " + e.getMessage());
        }
    }
}