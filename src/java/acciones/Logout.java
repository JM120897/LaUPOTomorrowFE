/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author ferna
 */
public class Logout extends ActionSupport {
    
    public Logout() {
    }
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", null);
         session.put("rol", null);
        return SUCCESS;
    }
    
}
