/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.rafaelaznar.bean.Cliente;

import net.rafaelaznar.helper.Conexion;
import net.rafaelaznar.helper.EncodingUtil;

import net.rafaelaznar.dao.ClienteDao;

/**
 *
 * @author rafa
 */
public class ClienteSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ClienteDao oClienteDAO = new ClienteDao();
            Cliente oCliente = new Cliente();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oCliente = gson.fromJson(jason, oCliente.getClass());
            Map<String, String> data = new HashMap<>();
            if (oCliente.getId() == 0 || oCliente.getId()==null) {
                oClienteDAO.create(oCliente);
            } else {
                oClienteDAO.set(oCliente);
            }
            data.put("status", "200");
            data.put("message", Integer.toString(oCliente.getId()));

            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("ClienteSaveJson: View Error: " + e.getMessage());
        }
    }
}
