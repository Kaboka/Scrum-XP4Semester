/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import Servlet.AjaxServlet;
import Utility.Utilities;
import classes.Course;
import classes.Student;
import com.google.gson.Gson;
import interfaces.IStudent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import jersey.StudentClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Søren
 */
public class StudentCommand implements AjaxCommand {

    public StudentCommand() {
        super();
    }

    @Override
    public String execute(HttpServletRequest req) throws Exception {

       StudentClient sC = new StudentClient();
        ArrayList<IStudent> students = new ArrayList<>();

        Collection<Course> poolA, poolB;
        poolA = new ArrayList<>();
        poolB = new ArrayList<>();

        poolA = Utilities.convertToCourse(req.getParameter("poolA"));
        System.out.println(req.getParameter("poolA") + " poolA");

        poolB = Utilities.convertToCourse(req.getParameter("poolB"));
        System.out.println(req.getParameter("poolB") + " poolB");


        JSONArray jStudents = sC.findAll_JSON(JSONArray.class);
        for (int i = 0; i < jStudents.length(); i++) {
            try {
                JSONObject student = (JSONObject) jStudents.get(i);
                JSONObject firstPrio1 = (JSONObject) student.get("firstPrio1");
                JSONObject firstPrio2 = (JSONObject) student.get("firstPrio2");
                JSONObject secondPrio1 = (JSONObject) student.get("secondPrio1");
                JSONObject secondPrio2 = (JSONObject) student.get("secondPrio2");
                Student aStudent = new Student(student.getString("fullName"), new Course(firstPrio1.getString("name")),
                        new Course(firstPrio2.getString("name")), new Course(secondPrio1.getString("name")),
                        new Course(secondPrio2.getString("name")));
                students.add(aStudent);
                
            } catch (JSONException ex) {
                Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        Utilities.calculateSatifaction(students, poolA, poolB);
        poolA = null;
        poolB = null;


        Gson json = new Gson();
        return json.toJson(Utilities.sort(students));
    }
    
    
    
}
