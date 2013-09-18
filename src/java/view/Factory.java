/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import commands.Command;
import java.util.HashMap;
import java.util.Map;


public class Factory {
    
    private static Factory instance = null;
    
    private Map<String, Command> commands;
    
    private Factory(){
        commands = new HashMap<String, Command>();
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
}
