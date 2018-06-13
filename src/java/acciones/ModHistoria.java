/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import classes.Notificacion;
import classes.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NotificacionREST;
import persistencia.UsuarioREST;

/**
 *
 * @author Juanma
 */
public class ModHistoria extends ActionSupport {

    Integer idHistoria;
    String tituloHistoria;
    String subtituloHistoria;
    Date fechaHistoria;
    String nombreUsuario;
    List<Categoria> listaCategoriaMenu = new ArrayList();
    Integer numNoti;
    List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();

    public ModHistoria() {
    }

    public String execute() throws Exception {
        Historia h = new Historia();
        HistoriaREST hr = new HistoriaREST();
        h.setFechaHistoria(fechaHistoria);
        h.setIdHistoria(idHistoria);
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gu = new GenericType<Usuario>() {
        };
        //Consume el REST para encontrar un usuario segun su nombre
        Usuario usu = ur.find_XML(gu, nombreUsuario);
        h.setNombreUsuario(usu);
        h.setSubtituloHistoria(subtituloHistoria);
        h.setTituloHistoria(tituloHistoria);
        //Consume el REST
        hr.edit_XML(h, idHistoria.toString());

        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);

        Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {
        };
        //Consume el REST para coger todas las notificaciones
        listNot = notifir.findAll_XML(gtnotificaciones);
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equalsIgnoreCase((String) sessionnotifi.get("usuario"))) {
                listaNotifi.add(notificacion);
            }

        }
        numNoti = listaNotifi.size();

        return SUCCESS;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public List<Notificacion> getListaNotifi() {
        return listaNotifi;
    }

    public void setListaNotifi(List<Notificacion> listaNotifi) {
        this.listaNotifi = listaNotifi;
    }

    public Integer getNumNoti() {
        return numNoti;
    }

    public void setNumNoti(Integer numNoti) {
        this.numNoti = numNoti;
    }

    public List<Notificacion> getListNot() {
        return listNot;
    }

    public void setList(List<Notificacion> listNot) {
        this.listNot = listNot;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }

    public String getSubtituloHistoria() {
        return subtituloHistoria;
    }

    public void setSubtituloHistoria(String subtituloHistoria) {
        this.subtituloHistoria = subtituloHistoria;
    }

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
