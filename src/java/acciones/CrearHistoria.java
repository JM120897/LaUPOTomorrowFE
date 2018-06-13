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
 * @author ferna
 */
public class CrearHistoria extends ActionSupport {

    String tituloHistoria;
    String subtituloHistoria;
    String nombreUsuario;
    Integer idHistoria;
    Date fechaHistoria;
    List<Categoria> listaCategoriaMenu = new ArrayList();
    int numNoti;

    public CrearHistoria() {
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        nombreUsuario = (String) session.get("usuario");
        Historia h = new Historia();
        h.setFechaHistoria(new Date());
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gu = new GenericType<Usuario>() {
        };
        //Consume el servicio REST para encontrar un usuario según su nombre de usuario
        Usuario usu = ur.find_XML(gu, nombreUsuario);
        h.setNombreUsuario(usu);
        h.setSubtituloHistoria(subtituloHistoria);
        h.setTituloHistoria(tituloHistoria);
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        HistoriaREST hr = new HistoriaREST();
        //Consume el servicio REST para crear una historia
        hr.create_XML(h);

        List<Notificacion> listNot = new ArrayList<>();
        List<Notificacion> listaNotifi = new ArrayList<>();

        Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {
        };
        //Consume el servicio REST para coger todas las notificaciones
        listNot = notifir.findAll_XML(gtnotificaciones);
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equalsIgnoreCase((String) sessionnotifi.get("usuario"))) {
                listaNotifi.add(notificacion);
            }

        }
        numNoti = listaNotifi.size();

        return SUCCESS;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public int getNumNoti() {
        return numNoti;
    }

    public void setNumNoti(int numNoti) {
        this.numNoti = numNoti;
    }

}
