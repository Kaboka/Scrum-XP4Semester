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
        peter.setForstePrio1(new Fag("Android"));
        peter.setForstePrio2(new Fag("CPlus"));
        peter.setAndenPrio1(new Fag("CSharp"));
        peter.setAndenPrio2(new Fag("Security"));
        peter.setTilfredshed(1);
        IElev anders = new Elev("Anders");
        anders.setForstePrio1(new Fag("Security"));
        anders.setForstePrio2(new Fag("CPlus"));
        anders.setAndenPrio1(new Fag("Android"));
        anders.setAndenPrio2(new Fag("CSharp"));
        anders.setTilfredshed(4);
        IElev sigurd = new Elev("Sigurd");
        sigurd.setForstePrio1(new Fag("Java"));
        sigurd.setForstePrio2(new Fag("UML"));
        sigurd.setAndenPrio1(new Fag("HEEYEEEAAAH"));
        sigurd.setAndenPrio2(new Fag("Magic The Gathering"));
        sigurd.setTilfredshed(3);
        //StudentClient sC = new StudentClient();
        ArrayList<IElev> elever = new ArrayList<>();
        elever.add(peter);
        elever.add(anders);
        elever.add(sigurd);
        
        //for(int i = 0; ARRAYLISTIGETFROMJSP.size(); i++){
        //    tempArray.add(sC.find_JSON(Istudent.class ,id)); 
        //}
        //ArrayList<Elev> tempElev; 
        //tempElev = SortingThing.sort(elever);
        Gson json = new Gson();
        String something = json.toJson(SortingThing.sort(elever));
        System.err.println(something);
        out.print(something);
        

       
    }
}
