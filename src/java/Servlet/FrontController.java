/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import commands.Command;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.Factory;

/**
 *
 * @author Søren
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String commandKey = request.getParameter("cmd");
        Command command = Factory.getInstance().findCommand(commandKey);
        String target = null;
        try {
            target = command.execute(request);
          
        } catch(Exception e){
            
        }
        
        request.getRequestDispatcher(target).forward(request, response);
    }

   
    }
