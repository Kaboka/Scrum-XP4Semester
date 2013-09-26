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
        IElev peter = new Elev("Peter");
        peter.setForstePrio1(new Fag("C#"));
        peter.setForstePrio2(new Fag("Apps and innovation"));
        peter.setAndenPrio1(new Fag("HCI"));
        peter.setAndenPrio2(new Fag("Test"));
        peter.setTilfredshed(1);
        IElev anders = new Elev("Anders");
        anders.setForstePrio1(new Fag("Test"));
        anders.setForstePrio2(new Fag("Database"));
        anders.setAndenPrio1(new Fag("Project management"));
        anders.setAndenPrio2(new Fag("Apps and innovation"));
        anders.setTilfredshed(4);
        IElev sigurd = new Elev("Sigurd");
        sigurd.setForstePrio1(new Fag("Globalization"));
        sigurd.setForstePrio2(new Fag("C#"));
        sigurd.setAndenPrio1(new Fag("HCI"));
        sigurd.setAndenPrio2(new Fag("Algorithms"));
        sigurd.setTilfredshed(3);
        //StudentClient sC = new StudentClient();
        ArrayList<IElev> elever = new ArrayList<>();
        elever.add(peter);
        elever.add(anders);
        elever.add(sigurd);
        Collection<Fag> poolA, poolB;
        poolA = convertToFag(req.getParameter("poolA"));
        poolB = convertToFag(req.getParameter("poolB"));
        Tilfredshed tilfredshed = new Tilfredshed();
        tilfredshed.udregnTilfredshed(elever, poolA, poolB);
        //String lol = req.getParameter("poolAFag1");
        //System.out.println(req.getRequestURL());
        String myParams = req.getParameter("poolA");
        
        String myParams2 = req.getParameter("poolB");
     //   String[] myParams2 = req.getParameterValues("hej2");
        System.out.println(myParams);
         System.out.println(myParams2);
        //for(int i = 0; ARRAYLISTIGETFROMJSP.size(); i++){
        //    tempArray.add(sC.find_JSON(Istudent.class ,id)); 
        //}
        //ArrayList<Elev> tempElev; 
        //tempElev = SortingThing.sort(elever);
        Gson json = new Gson();
        String something = json.toJson(SortingThing.sort(elever));
        out.print(something);
        

       
    }
 
 public Collection<Fag> convertToFag (String string){
     Collection<Fag> fagListe = new ArrayList<Fag>();
     string = string.substring(1, string.length()-1);
     
     String[] fagArray = string.split(",");
     
     for (int i = 0; i < fagArray.length; i++) {
         Fag fag = new Fag (fagArray[i]);
         fagListe.add(fag);
     }
     
     return fagListe;
 }
}
