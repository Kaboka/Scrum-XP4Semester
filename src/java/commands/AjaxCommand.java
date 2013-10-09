/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nicklas Hemmingsen
 */
public interface AjaxCommand {
    void execute(HttpServletRequest request) throws Exception;
}
