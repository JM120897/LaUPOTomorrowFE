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
import persistencia.ComentarioREST;
import persistencia.NoticiaREST;
import persistencia.NotificacionREST;
import persistencia.TagREST;

import java.util.Collection;

/**
 *
 * @author ferna
 */
public class IrNoticia extends ActionSupport {

    Integer idNoticia;
    Integer idNoticia2;
    String imagen;
    String localizacion;
    Date fechaNoticia;
    String cuerpoNoticia;
    String subtituloNoticia;
    String tituloNoticia;
    String nombreRealUsuario;
    String nombreUsuario;
    String nombreCategoria;
    List<Tag> tags = new ArrayList();
    List<Categoria> listaCategoriaMenu = new ArrayList();
    List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;

    public IrNoticia() {
    }

    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();
        GenericType<Noticia> gt = new GenericType<Noticia>() {
        };
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        //Consume el servicio REST para encontrar una noticia segun su id
        Noticia n = nr.find_XML(gt, idNoticia.toString());
        this.cuerpoNoticia = n.getCuerpoNoticia();
        this.fechaNoticia = n.getFechaNoticia();
        this.imagen = n.getImagen();
        this.subtituloNoticia = n.getSubtituloNoticia();
        this.tituloNoticia = n.getTituloNoticia();
        if (n.getNombreUsuario() != null) {
            this.nombreRealUsuario = n.getNombreUsuario().getNombreReal();
            this.nombreUsuario = n.getNombreUsuario().getNombreUsuario();
        }
        if (n.getNombreCategoria() != null) {
            this.nombreCategoria = n.getNombreCategoria().getNombreCategoria();
        }
        this.localizacion = n.getLocalizacion();

        ComentarioREST cr = new ComentarioREST();
        GenericType<List<Comentario>> gc = new GenericType<List<Comentario>>() {
        };
        //Consume el servicio REST para coger todos los comentarios
        List<Comentario> list = cr.findAll_XML(gc);

        for (Comentario c : list) {
            if (c.getIdNoticia().getIdNoticia().equals(idNoticia)) {
                listaComentarios.add(c);
            }
        }
        TagREST tr = new TagREST();
        GenericType<List<Tag>> gtag = new GenericType<List<Tag>>() {
        };
        //Consume el servicio REST para coger todos los tags
        List<Tag> listaTags = tr.findAll_XML(gtag);

        for (Tag tg : listaTags) {
            if (tg.getIdNoticia().getIdNoticia().equals(idNoticia)) {
                tags.add(tg);
            }
        }
        idNoticia2 = idNoticia;
        Map session = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotifi = new GenericType<List<Notificacion>>() {
        };
        //Consume el servicio REST para coger todas las notificaciones
        listNot = notifir.findAll_XML(gtnotifi);
        for (Notificacion not : listNot) {
            if (n.getNombreUsuario() != null && n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(not);
            }

        }
        numNoti = listaNotifi.size();

        return SUCCESS;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    List<Comentario> listaComentarios = new ArrayList();

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

    public Integer getIdNoticia2() {
        return idNoticia2;
    }

    public void setIdNoticia2(Integer idNoticia2) {
        this.idNoticia2 = idNoticia2;
    }

    public List getTags() {
        return tags;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public String getNombreRealUsuario() {
        return nombreRealUsuario;
    }

    public void setNombreRealUsuario(String nombreRealUsuario) {
        this.nombreRealUsuario = nombreRealUsuario;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

}
