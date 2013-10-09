/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import jersey.CourseClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Nicklas Hemmingsen
 */
public class GetCoursesU4 implements AjaxCommand{

    @Override
    public String execute(HttpServletRequest request) throws Exception {

        CourseClient cC = new CourseClient();
        ArrayList<String> names = new ArrayList<>();
        
        JSONArray courses = cC.findAll_JSON(JSONArray.class);
        for(int i = 0; i < courses.length(); i++){
            JSONObject course = (JSONObject) courses.get(i);
            names.add(course.getString("name"));
        }
        
        Gson json = new Gson();
        String str = json.toJson(names);
        
        return str;
    }
    
    
}
