/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.operaciones;

import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author rafa
 */
public class ClienteGetprettycolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String data = "{\"data\": [\"id\", \"nombre\", \"primer apellido\", \"segundo apellido\", \"email\"]}";
            return data;
        } catch (Exception e) {
            throw new ServletException("ClienteGetpagesJson: View Error: " + e.getMessage());
        }
    }
}
