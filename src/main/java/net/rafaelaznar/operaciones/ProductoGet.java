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
import net.rafaelaznar.bean.Producto;
import net.rafaelaznar.dao.ProductoDao;

public class ProductoGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                ProductoDao oProductoDAO = new ProductoDao();                             
                Producto oProducto=oProductoDAO.get(Integer.parseInt(request.getParameter("id")));
                data = new Gson().toJson(oProducto);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("ProductoGetJson: View Error: " + e.getMessage());
        }
    }
}