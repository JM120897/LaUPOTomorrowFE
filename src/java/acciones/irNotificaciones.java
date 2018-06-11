/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Noticia;
import classes.Notificacion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.NoticiaREST;
import persistencia.NotificacionREST;

/**
 *
 * @author ferna
 */
public class irNotificaciones extends ActionSupport {

    public irNotificaciones() {
    }
    List<String> nombres = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
 List<Categoria> listaCategoriaMenu = new ArrayList();
int numNoti = 0;
    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public String execute() throws Exception {
        NotificacionREST nr = new NotificacionREST();
        GenericType<List<Notificacion>> gt = new GenericType<List<Notificacion>>() {
        };
        Map session = (Map) ActionContext.getContext().get("session");
        List<Notificacion> list = nr.findAll_XML(gt);
        for (Notificacion n : list) {
            if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(n);
            }

        }
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        
         numNoti = listaNotifi.size();
        return SUCCESS;

    }

    public List<String> getNombres() {
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }

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

}
