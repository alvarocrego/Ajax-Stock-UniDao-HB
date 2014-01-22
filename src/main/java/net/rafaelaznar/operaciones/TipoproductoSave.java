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

import net.rafaelaznar.helper.Conexion;
import net.rafaelaznar.helper.EncodingUtil;

import net.rafaelaznar.dao.TipoproductoDao;

/**
 *
 * @author rafa
 */
public class TipoproductoSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            TipoproductoDao oTipoproductoDAO = new TipoproductoDao();
            Tipoproducto oTipoproducto = new Tipoproducto();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oTipoproducto = gson.fromJson(jason, oTipoproducto.getClass());
            Map<String, String> data = new HashMap<>();
            if (oTipoproducto.getId() == 0 || oTipoproducto.getId()==null) {
                oTipoproductoDAO.create(oTipoproducto);
            } else {
                oTipoproductoDAO.set(oTipoproducto);
            }
            data.put("status", "200");
            data.put("message", Integer.toString(oTipoproducto.getId()));

            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("TipoproductoSaveJson: View Error: " + e.getMessage());
        }
    }
}
