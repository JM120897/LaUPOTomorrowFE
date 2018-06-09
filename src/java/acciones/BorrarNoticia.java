/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import persistencia.NoticiaREST;

/**
 *
 * @author ferna
 */
public class BorrarNoticia extends ActionSupport {
    
    public BorrarNoticia() {
    }
    
    Integer idNoticia;
    
    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();
        
        nr.remove(idNoticia.toString());
        return SUCCESS;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }
    
    
}
