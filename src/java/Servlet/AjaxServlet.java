/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import RESTClient.StudentClient;
import RenameLaterInterfaces.Istudent;
import Utility.SortingThing;
import classes.Elev;
import classes.Fag;
import com.google.gson.Gson;
import com.sun.jersey.json.impl.writer.A2EXmlStreamWriterProxy;
import commands.AjaxCommand;
import interfaces.IElev;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Elev peter = new Elev("Peter");
        peter.setForstePrio1(new Fag("Android"));
        peter.setForstePrio2(new Fag("CPlus"));
        peter.setAndenPrio1(new Fag("CSharp"));
        peter.setAndenPrio2(new Fag("Security"));
        peter.setTilfredshed(1);
        Elev anders = new Elev("Anders");
        anders.setForstePrio1(new Fag("Security"));
        anders.setForstePrio2(new Fag("CPlus"));
        anders.setAndenPrio1(new Fag("Android"));
        anders.setAndenPrio2(new Fag("CSharp"));
        anders.setTilfredshed(4);
        Elev sigurd = new Elev("Sigurd");
        sigurd.setForstePrio1(new Fag("Java"));
        sigurd.setForstePrio2(new Fag("UML"));
        sigurd.setAndenPrio1(new Fag("Harlem Shake"));
        sigurd.setAndenPrio2(new Fag("Magic The Gathering"));
        sigurd.setTilfredshed(3);
        StudentClient sC = new StudentClient();
        ArrayList<Elev> elever = new ArrayList<>();
        elever.add(peter);
        elever.add(anders);
        elever.add(sigurd);
        final ArrayList<Elev> studentsSorted = new ArrayList<>();
        
        
        JSONArray students = sC.findAll_JSON(JSONArray.class);
        for(int i = 0; i < students.length(); i++){
            try {
                JSONObject student = (JSONObject)students.get(i);
                Elev aElev = new Elev(student.getString("fullName"));
                JSONObject firstPrio1 = (JSONObject)student.get("firstPrio1");
                JSONObject firstPrio2 = (JSONObject)student.get("firstPrio2");
                JSONObject secondPrio1 = (JSONObject)student.get("secondPrio1");
                JSONObject secondPrio2 = (JSONObject)student.get("secondPrio2");
                aElev.setForstePrio1(new Fag(firstPrio1.getString("name")));
                aElev.setForstePrio2(new Fag(firstPrio2.getString("name")));
                aElev.setAndenPrio1(new Fag(secondPrio1.getString("name")));
                aElev.setAndenPrio2(new Fag(secondPrio2.getString("name")));
                aElev.setTilfredshed(1);
                studentsSorted.add(aElev);
            } catch (JSONException ex) {
                Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Gson json = new Gson();
        String returnSorted = json.toJson(SortingThing.sort(studentsSorted));
        System.err.println(returnSorted);
        out.print(returnSorted);
        

       
    }
}
