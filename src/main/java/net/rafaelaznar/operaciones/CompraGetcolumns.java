/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.operaciones;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.rafaelaznar.dao.CompraDao;

/**
 *
 * @author rafa
 */
public class CompraGetcolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<String> alColumns = null;
        try {
            CompraDao oCompraDAO = new CompraDao();
            alColumns = (ArrayList<String>) oCompraDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            //String data = "{\"data\":" + "[\"id\",\"nombre\",\"ape1\",\"ape2\",\"email\"]" + "}";
             data = "{\"data\":" + data + "}";
            return data;
        } catch (Exception e) {
            throw new ServletException("CompraGetcolumnsJson: View Error: " + e.getMessage());
        }
    }

}
