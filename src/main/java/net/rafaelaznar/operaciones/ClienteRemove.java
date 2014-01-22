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

import net.rafaelaznar.dao.ClienteDao;

/**
 *
 * @author rafa
 */
public class ClienteRemove implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ClienteDao oClienteDAO = new ClienteDao();
            Cliente oCliente = new Cliente();
            oCliente.setId(Integer.parseInt(request.getParameter("id")));
            Map<String, String> data = new HashMap<>();
            oClienteDAO.remove(oCliente);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id=" + oCliente.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("ClienteRemoveJson: View Error: " + e.getMessage());
        }
    }
}
