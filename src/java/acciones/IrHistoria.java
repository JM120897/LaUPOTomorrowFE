/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import classes.Noticia;
import classes.Notificacion;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;
import persistencia.NotificacionREST;

import classes.Usuario;

/**
 *
 * @author ferna
 */
public class IrHistoria extends ActionSupport {

    Integer idHistoria;
    String tituloHistoria;
    String subtituloHistoria;
    Date fechaHistoria;
    String nombreUsuario;
    List<Noticia> listNoticias = new ArrayList();
    List<Noticia> listaNoticiasHistoria = new ArrayList();
    List<Categoria> listaCategoriaMenu = new ArrayList();
    List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;

    public IrHistoria() {
    }

    public String execute() throws Exception {

        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        Historia h = new Historia();
        HistoriaREST hr = new HistoriaREST();
        GenericType<Historia> gh = new GenericType<Historia>() {
        };
        //Consume el servicio REST para encontrar una historia según su id
        h = hr.find_XML(gh, idHistoria.toString());
        tituloHistoria = h.getTituloHistoria();
        subtituloHistoria = h.getSubtituloHistoria();
        fechaHistoria = h.getFechaHistoria();
        NoticiaREST nr = new NoticiaREST();
        GenericType<List<Noticia>> gn = new GenericType<List<Noticia>>() {
        };
        //Consume el servicio REST para coger todas las noticias
        listNoticias = nr.findAll_XML(gn);
        for (Noticia n : listNoticias) {
            if (n.getIdHistoria() != null && n.getIdHistoria().getIdHistoria().equals(idHistoria)) {
                listaNoticiasHistoria.add(n);
            }
        }

        //Ordena las noticias y las historias cronológicamente
        listaNoticiasHistoria.sort(new Comparator<Noticia>() {
            public int compare(Noticia o1, Noticia o2) {
                return o1.getFechaNoticia().compareTo(o2.getFechaNoticia());
            }
        });

        nombreUsuario = h.getNombreUsuario().getNombreUsuario();
        Map session = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gt = new GenericType<List<Notificacion>>() {
        };
        //Consume el servicio REST para coger todas las notificaciones
        listNot = notifir.findAll_XML(gt);
        for (Notificacion n : listNot) {
            if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(n);
            }

        }
        numNoti = listaNotifi.size();

        return SUCCESS;
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

    public List<Noticia> getListNoticias() {
        return listNoticias;
    }

    public void setListNoticias(List<Noticia> listNoticias) {
        this.listNoticias = listNoticias;
    }

    public List<Noticia> getListaNoticiasHistoria() {
        return listaNoticiasHistoria;
    }

    public void setListaNoticiasHistoria(List<Noticia> listaNoticiasHistoria) {
        this.listaNoticiasHistoria = listaNoticiasHistoria;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public List<Notificacion> getListNot() {
        return listNot;
    }

    public void setList(List<Notificacion> listNot) {
        this.listNot = listNot;
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
