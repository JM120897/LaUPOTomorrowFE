/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Comentario;
import classes.Noticia;
import classes.Notificacion;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.ComentarioREST;
import persistencia.NotificacionREST;

/**
 *
 * @author ferna
 */
public class irModCom extends ActionSupport {

    public irModCom() {
    }
    
    Integer idNoticia;
    String mensaje;
    Integer idPadre;
    Date fechaComentario;
    String nombreUsuario;
    Integer idComentario;
 
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public String execute() throws Exception {
        ComentarioREST cr = new ComentarioREST();
        GenericType<Comentario> lc = new GenericType<Comentario>() {
        }; 
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        
        Comentario c = cr.find_XML(lc, idComentario.toString());
        mensaje = c.getMensaje();
        idPadre = c.getIdPadre();
        fechaComentario = c.getFechaComentario();
        nombreUsuario = c.getNombreUsuario();
        idComentario = c.getIdComentario();
        idNoticia = c.getIdNoticia().getIdNoticia();
       Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {
        };
        listNot = notifir.findAll_XML(gtnotificaciones);
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equals(sessionnotifi.get("usuario"))) {
                listaNotifi.add(notificacion);
            }

        }
        numNoti = listaNotifi.size();
       
        
        
        return SUCCESS;
    }
    
    /////////////////
      List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;
    
    public List<Notificacion> getListaNotifi() {
        return listaNotifi;
    }

    public void setListaNotifi(List<Notificacion> listaNotifi) {
        this.listaNotifi = listaNotifi;
    }

    public int getNumNoti() {
        return numNoti;
    }

    public void setNumNoti(int numNoti) {
        this.numNoti = numNoti;
    }
     public List<Notificacion> getListNot() {
        return listNot;
    }

    public void setList(List<Notificacion> listNot) {
        this.listNot = listNot;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia2(Integer idNoticia2) {
        this.idNoticia = idNoticia2;
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
