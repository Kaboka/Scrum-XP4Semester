package commands;

import Utility.Utilities;
import classes.Course;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import jersey.CourseClient;
import org.codehaus.jettison.json.JSONObject;

public class PersistPoolsCommand implements AjaxCommand{

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        CourseClient cc = new CourseClient();
        ArrayList<Course> subjects = (ArrayList)Utilities.convertToCourse(request.getParameter("subjects"));
        ArrayList<Course> poolA = (ArrayList)Utilities.convertToCourse(request.getParameter("poolA"));
        ArrayList<Course> poolB = (ArrayList)Utilities.convertToCourse(request.getParameter("poolB"));
        for (Course course : subjects) {
            JSONObject json = cc.find_JSON(JSONObject.class, course.getName());
            json.put("pool", 0);
            cc.edit_JSON(json);
        }
        for (Course course : poolA) {
            JSONObject json = cc.find_JSON(JSONObject.class, course.getName());
            json.put("pool", 1);
            cc.edit_JSON(json);
        }
        for (Course course : poolB) {
            JSONObject json = cc.find_JSON(JSONObject.class, course.getName());
            json.put("pool", 2);
            cc.edit_JSON(json);
        }
        return "who cares";
    }

}
