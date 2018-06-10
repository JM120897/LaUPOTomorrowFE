/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import persistencia.ComentarioREST;

/**
 *
 * @author ferna
 */
public class borrarCom extends ActionSupport {
    
    Integer idNoticia2;
    Integer idComentario;
    public borrarCom() {
    }
    
    public String execute() throws Exception {
        ComentarioREST cr= new ComentarioREST();
        cr.remove(idComentario.toString());
        return SUCCESS;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getIdNoticia2() {
        return idNoticia2;
    }

    public void setIdNoticia2(Integer idNoticia2) {
        this.idNoticia2 = idNoticia2;
    }
    
}
