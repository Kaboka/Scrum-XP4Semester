/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Utility.Utilities;
import classes.Elev;
import classes.Fag;
import com.google.gson.Gson;
import commands.AjaxCommand;
import interfaces.IStudent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jersey.StudentClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import view.Factory;

/**
 *
 * @author Nicklas Hemmingsen
 */
public class AjaxServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String commandKey = req.getParameter("command");
        
        AjaxCommand command = Factory.getInstance().findAjaxCommand(commandKey);
        
        try{
            command.execute(req);
        } catch (Exception ex) {
            Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//        StudentClient sC = new StudentClient();
//        ArrayList<IStudent> elever = new ArrayList<>();
//
//        Collection<Fag> poolA, poolB;
//        poolA = new ArrayList<>();
//        poolB = new ArrayList<>();
//
//        poolA = Utilities.convertToFag(req.getParameter("poolA"));
//        System.out.println(req.getParameter("poolA") + " poolA");
//
//        poolB = Utilities.convertToFag(req.getParameter("poolB"));
//        System.out.println(req.getParameter("poolB") + " poolB");
//
//
//        JSONArray students = sC.findAll_JSON(JSONArray.class);
//        for (int i = 0; i < students.length(); i++) {
//            try {
//                JSONObject student = (JSONObject) students.get(i);
//                JSONObject firstPrio1 = (JSONObject) student.get("firstPrio1");
//                JSONObject firstPrio2 = (JSONObject) student.get("firstPrio2");
//                JSONObject secondPrio1 = (JSONObject) student.get("secondPrio1");
//                JSONObject secondPrio2 = (JSONObject) student.get("secondPrio2");
//                Elev aElev = new Elev(student.getString("fullName"), new Fag(firstPrio1.getString("name")),
//                        new Fag(firstPrio2.getString("name")), new Fag(secondPrio1.getString("name")),
//                        new Fag(secondPrio2.getString("name")));
//                elever.add(aElev);
//            } catch (JSONException ex) {
//                Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//
//        Utilities.udregnTilfredshed(elever, poolA, poolB);
//        poolA = null;
//        poolB = null;
//
//
//        Gson json = new Gson();
//        String something = json.toJson(Utilities.sort(elever));
//        out.print(something);
   }
}

