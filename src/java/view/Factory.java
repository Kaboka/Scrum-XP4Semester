/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import commands.AjaxCommand;
import commands.Command;
import commands.StudentCommand;
import java.util.HashMap;
import java.util.Map;


public class Factory {
    
    private static Factory instance = null;
    
    private Map<String, Command> commands;
    private Map<String, AjaxCommand> ajaxCommands;
    
    private Factory(){
        commands = new HashMap<String, Command>();
        ajaxCommands = new HashMap<String, AjaxCommand>();
        ajaxCommands.put("getStudents", new StudentCommand());
        
        
    }
    
    public static Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }
    
    public Command findCommand(String key){
        if(key == null){
            key = "index";
        }
        return commands.get(key);
    }
    
    public AjaxCommand findAjaxCommand(String key){
        if(key == null){
            key = "index";
        }
        return ajaxCommands.get(key);
    }
}
