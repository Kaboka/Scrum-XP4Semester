/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import commands.AjaxCommand;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.Factory;

/**
 *
 * @author Nicklas Hemmingsen
 */
public class AjaxServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        
        Factory factory = Factory.getInstance();
       
         AjaxCommand command =  factory.findAjaxCommand(req.getParameter("command"));
        try {
           out.print( command.execute(req));
        } catch (Exception ex) {
            Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        
        
        
        
       

        
    }

   
}
