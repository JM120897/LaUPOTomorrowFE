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

/**
 *
 * @author ferna
 */
public class IrModHistoria extends ActionSupport {
    
    public IrModHistoria() {
    }
     Integer idHistoria;
    String tituloHistoria;
     String subtituloHistoria;
     Date fechaHistoria;
     String nombreUsuario;
      List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    public String execute() throws Exception {
        Historia h = new Historia();
        HistoriaREST hr = new HistoriaREST();
        GenericType<Historia> gh = new GenericType<Historia>(){};
        h=hr.find_XML(gh, idHistoria.toString());
        tituloHistoria=h.getTituloHistoria();
        subtituloHistoria = h.getSubtituloHistoria();
        fechaHistoria= h.getFechaHistoria();
        nombreUsuario=h.getNombreUsuario().getNombreUsuario();
        idHistoria= h.getIdHistoria();
         CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        Map session = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gt = new GenericType<List<Notificacion>>() {
        };
        listNot = notifir.findAll_XML(gt);
        for (Notificacion n : listNot) {
            if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(n);
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
    ////////////////////////////

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
