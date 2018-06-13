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
import classes.Tag;
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
import persistencia.NoticiaREST;
import persistencia.NotificacionREST;
import persistencia.TagREST;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author ferna
 */
public class irModNot extends ActionSupport {

    Integer idNoticia;
    String imagen;
    String localizacion;
    Date fechaNoticia;
    String cuerpoNoticia;
    String subtituloNoticia;
    String tituloNoticia;
    String nombreRealUsuario;
    String nombreUsuario;
    String nombreCat;
    String tag;
    List<Categoria> listaCat = new ArrayList();
    String def;
    Integer idHistori;
    String tags = "";
    List<Historia> listaHistoriasUsuario = new ArrayList();
    String tituloHist;
    List<Categoria> listaCategoriaMenu = new ArrayList();
    List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;

    public irModNot() {
    }

    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();
        GenericType<Noticia> gt = new GenericType<Noticia>() {
        };
        Map session = (Map) ActionContext.getContext().get("session");
        //Consume el servicio REST para encontrar una noticia segun su id
        Noticia n = nr.find_XML(gt, idNoticia.toString());
        this.cuerpoNoticia = n.getCuerpoNoticia();
        this.fechaNoticia = n.getFechaNoticia();
        this.imagen = n.getImagen();
        this.subtituloNoticia = n.getSubtituloNoticia();
        this.tituloNoticia = n.getTituloNoticia();
        this.nombreRealUsuario = n.getNombreUsuario().getNombreReal();
        this.nombreUsuario = n.getNombreUsuario().getNombreUsuario();
        if (n.getNombreCategoria() != null) {
            this.nombreCat = n.getNombreCategoria().getNombreCategoria();
        }
        this.localizacion = n.getLocalizacion();
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las noticias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);

        CategoriaREST nc = new CategoriaREST();

        GenericType<List<Categoria>> gc = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCat = nc.findAll_XML(gc);
        int i = -1;
        for (Categoria c : listaCat) {
            if (c.getNombreCategoria().equals(nombreCat)) {
                i = listaCat.indexOf(c);
            }
        }
        if (i != -1) {

            listaCat.remove(i);
        }

        Historia hn = n.getIdHistoria();

        if (hn != null) {
            this.idHistori = hn.getIdHistoria();
            this.tituloHist = hn.getTituloHistoria();
        } else {
            Historia hVacia = new Historia();
            hVacia.setIdHistoria(-1);
            hVacia.setTituloHistoria("Ninguna");
            this.idHistori = hVacia.getIdHistoria();
            this.tituloHist = hVacia.getTituloHistoria();
        }

        HistoriaREST hr = new HistoriaREST();
        GenericType<List<Historia>> gh = new GenericType<List<Historia>>() {
        };
        //Consume el servicio REST para coger todas las historias
        listaHistoriasUsuario = hr.findAll_XML(gh);
        int j = -1;

        for (Historia h2 : listaHistoriasUsuario) {
            if (h2.getIdHistoria().equals(idHistori)) {
                j = listaHistoriasUsuario.indexOf(h2);
            }

        }

        if (j != -1) {

            listaHistoriasUsuario.remove(j);
        }

        TagREST tr = new TagREST();
        GenericType<List<Tag>> gtag = new GenericType<List<Tag>>() {
        };
        //Consume el servicio REST para coger todos los tags
        List<Tag> listaTags = tr.findAll_XML(gtag);

        for (Tag tg : listaTags) {
            if (tg.getIdNoticia().getIdNoticia().equals(idNoticia)) {
                tags += tg.getNombreTag() + " ";
            }
        }

        Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {
        };
        //Consume el servicio REST para coger todas las notificaciones
        listNot = notifir.findAll_XML(gtnotificaciones);
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equals(sessionnotifi.get("usuario"))) {
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<Historia> getListaHistoriasUsuario() {
        return listaHistoriasUsuario;
    }

    public void setListaHistoriasUsuario(List<Historia> listaHistoriasUsuario) {
        this.listaHistoriasUsuario = listaHistoriasUsuario;
    }

    public Integer getIdHistori() {
        return idHistori;
    }

    public void setIdHistori(Integer idHistori) {
        this.idHistori = idHistori;
    }

    public String getTituloHist() {
        return tituloHist;
    }

    public void setTituloHist(String tituloHist) {
        this.tituloHist = tituloHist;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public List<Categoria> getListaCat() {
        return listaCat;
    }

    public void setListaCat(List<Categoria> listaCat) {
        this.listaCat = listaCat;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Date getFechaNoticia() {
        return fechaNoticia;
    }

    public void setFechaNoticia(Date fechaNoticia) {
        this.fechaNoticia = fechaNoticia;
    }

    public String getCuerpoNoticia() {
        return cuerpoNoticia;
    }

    public void setCuerpoNoticia(String cuerpoNoticia) {
        this.cuerpoNoticia = cuerpoNoticia;
    }

    public String getSubtituloNoticia() {
        return subtituloNoticia;
    }

    public void setSubtituloNoticia(String subtituloNoticia) {
        this.subtituloNoticia = subtituloNoticia;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getNombreRealUsuario() {
        return nombreRealUsuario;
    }

    public void setNombreRealUsuario(String nombreRealUsuario) {
        this.nombreRealUsuario = nombreRealUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
