/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import RenameLaterInterfaces.Istudent;
import Utility.SortingThing;
import classes.Elev;
import classes.Fag;
import classes.Tilfredshed;
import com.google.gson.Gson;
import com.sun.jersey.json.impl.writer.A2EXmlStreamWriterProxy;
import commands.AjaxCommand;
import interfaces.IElev;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
        IElev elev1 = new Elev("Bjarke Carlsen",new Fag("C#"),new Fag("HCI"),new Fag("Apps and innovation"),new Fag("Algorithms"));
        IElev elev2 = new Elev("Martin Olgenkjær",new Fag("Project management"),new Fag("HCI"),new Fag("Databases"),new Fag("Test"));
        IElev elev3 = new Elev("Henrik Stavnem",new Fag("Apps and innovation"),new Fag("Globalization"),new Fag("C#"),new Fag("Databases"));
        IElev elev4 = new Elev("Nicklas Thomsen",new Fag("Algorithms"),new Fag("Project management"),new Fag("HCI"),new Fag("Test"));
        //StudentClient sC = new StudentClient();
        ArrayList<IElev> elever = new ArrayList<>();
        elever.add(elev1);
        elever.add(elev2);
        elever.add(elev3);
        elever.add(elev4);
        Collection<Fag> poolA, poolB;
        poolA = convertToFag(req.getParameter("poolA"));
        poolB = convertToFag(req.getParameter("poolB"));
        Tilfredshed tilfredshed = new Tilfredshed();
        tilfredshed.udregnTilfredshed(elever, poolA, poolB);
        //String lol = req.getParameter("poolAFag1");
        //System.out.println(req.getRequestURL());
        String myParams = req.getParameter("poolA");
        
        
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
        String something = json.toJson(SortingThing.sort(elever));
        out.print(something);
        

       
    }
 
 public Collection<Fag> convertToFag (String string){
     Collection<Fag> fagListe = new ArrayList<Fag>();
     string = string.replaceAll("\"", "");
     string = string.substring(1, string.length()-1);
     
     String[] fagArray = string.split(",");
     
     for (int i = 0; i < fagArray.length; i++) {
         Fag fag = new Fag (fagArray[i]);
         fagListe.add(fag);
         System.out.println("Fag nr:" + i + ", navn: " + fag.getName());
     }
     
     return fagListe;
 }
}
