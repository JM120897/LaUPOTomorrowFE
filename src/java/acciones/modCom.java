/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Comentario;
import classes.Noticia;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import persistencia.ComentarioREST;
import persistencia.NoticiaREST;

/**
 *
 * @author ferna
 */
public class modCom extends ActionSupport {
    
    public modCom() {
    }
    
    Integer idNoticia;
    String mensaje;
    Integer idPadre;
    Date fechaComentario;
    String nombreUsuario;
    Integer idComentario;

    public String execute() throws Exception {
        
        ComentarioREST cr = new ComentarioREST();
        GenericType<Comentario> gc = new GenericType<Comentario>(){};
        
        Comentario c = cr.find_XML(gc,idComentario.toString());
       
        
        
        c.setMensaje(mensaje);
       
      
       
        cr.edit_XML(c,idComentario.toString());
        return SUCCESS;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }
    
   
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Integer getIdPadre() {
        return idPadre;
    }
    
    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }
    
    public Date getFechaComentario() {
        return fechaComentario;
    }
    
    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public Integer getIdComentario() {
        return idComentario;
    }
    
    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }
    
}