/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import classes.Course;
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
public class GetCoursesU5Command implements AjaxCommand{

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        CourseClient cC = new CourseClient();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Course> names = new ArrayList<>();
        ArrayList<String> poolA = new ArrayList<>();
        ArrayList<String> poolB = new ArrayList<>();
        ArrayList<ArrayList<String>> bothPools = new ArrayList<>();
        
        JSONArray courses = cC.findAll_JSON(JSONArray.class);
        for(int i = 0; i < courses.length(); i++){
            JSONObject course = (JSONObject) courses.get(i);
            String name = course.getString("name");
            names.add(new Course(name));
            int temp1 = course.getInt("pool");
            temp.add(temp1);
            if(temp.get(i) == 1){
                poolA.add(names.get(i).getName());
            }
            else if(temp.get(i) == 2){
                poolB.add(names.get(i).getName());
            }
        }
        
        Gson json = new Gson();
        bothPools.add(poolA);
        bothPools.add(poolB);
        String str = json.toJson(bothPools);
        System.out.println(str);
        
        return str;
    }
    
}
