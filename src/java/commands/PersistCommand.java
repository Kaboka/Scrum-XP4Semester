/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import Utility.Utilities;
import classes.Course;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import jersey.CourseClient;
import jersey.StudentClient;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author
 * kasper
 */
public class PersistCommand implements AjaxCommand{

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        StudentClient client = new StudentClient();
        CourseClient courseClient = new CourseClient();
        ArrayList<Course> firstPrio = (ArrayList)Utilities.convertToCourse(request.getParameter("fPrio"));
        ArrayList<Course> secondPrio = (ArrayList)Utilities.convertToCourse(request.getParameter("sPrio"));
        
        JSONObject student = client.find_JSON(JSONObject.class, request.getParameter("id"));
        JSONObject courseFirstPrio1 = courseClient.find_JSON(JSONObject.class, firstPrio.get(0).getName());
        JSONObject courseFirstPrio2 = courseClient.find_JSON(JSONObject.class, firstPrio.get(1).getName());
        JSONObject courseSecondPrio1 = courseClient.find_JSON(JSONObject.class, secondPrio.get(0).getName());
        JSONObject courseSecondPrio2 = courseClient.find_JSON(JSONObject.class, secondPrio.get(1).getName());
        student.put("firstPrio1", courseFirstPrio1);
        student.put("firstPrio2", courseFirstPrio2);
        student.put("secondPrio1", courseSecondPrio1);
        student.put("secondPrio2", courseSecondPrio2);
        client.edit_JSON(student);
        return "sucess";
    }
}
