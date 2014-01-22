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
import net.rafaelaznar.bean.Tipoproducto;

import net.rafaelaznar.dao.TipoproductoDao;

/**
 *
 * @author rafa
 */
public class TipoproductoRemove implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            TipoproductoDao oTipoproductoDAO = new TipoproductoDao();
            Tipoproducto oTipoproducto = new Tipoproducto();
            oTipoproducto.setId(Integer.parseInt(request.getParameter("id")));
            Map<String, String> data = new HashMap<>();
            oTipoproductoDAO.remove(oTipoproducto);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id=" + oTipoproducto.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("TipoproductoRemoveJson: View Error: " + e.getMessage());
        }
    }
}
