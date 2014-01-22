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
import net.rafaelaznar.bean.Producto;

import net.rafaelaznar.helper.Conexion;
import net.rafaelaznar.helper.EncodingUtil;

import net.rafaelaznar.dao.ProductoDao;

/**
 *
 * @author rafa
 */
public class ProductoSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ProductoDao oProductoDAO = new ProductoDao();
            Producto oProducto = new Producto();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oProducto = gson.fromJson(jason, oProducto.getClass());
            Map<String, String> data = new HashMap<>();
            if (oProducto.getId() == 0) {
                oProductoDAO.create(oProducto);
            } else {
                oProductoDAO.set(oProducto);
            }
            data.put("status", "200");
            data.put("message", Integer.toString(oProducto.getId()));

            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("ProductoSaveJson: View Error: " + e.getMessage());
        }
    }
}
