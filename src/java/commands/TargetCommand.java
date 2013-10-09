/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Søren
 */
public class TargetCommand implements Command{
    private String target;
    private String command = "";
    
    public TargetCommand(String target){
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
