/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Comentario;
import classes.Noticia;
import classes.Tag;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.ComentarioREST;
import persistencia.NoticiaREST;

/**
 *
 * @author ferna
 */
public class IrNoticia extends ActionSupport {

    public IrNoticia() {
    }

    Integer idNoticia;
    String imagen;
    String localizacion;
    Date fechaNoticia;
    String cuerpoNoticia;
    String subtituloNoticia;
    String tituloNoticia;
    String nombreRealUsuario;
    String nombreUsuario;
    String nombreCategoria;
    String tag;
    
    List<Comentario> listaComentarios = new ArrayList();
    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();
        GenericType<Noticia> gt = new GenericType<Noticia>() {
        };
        Noticia n = nr.find_XML(gt, idNoticia.toString());
        this.cuerpoNoticia = n.getCuerpoNoticia();
        this.fechaNoticia = n.getFechaNoticia();
        this.imagen = n.getImagen();
        this.subtituloNoticia = n.getSubtituloNoticia();
        this.tituloNoticia = n.getTituloNoticia();
        this.nombreRealUsuario=n.getNombreUsuario().getNombreReal();
        this.nombreUsuario = n.getNombreUsuario().getNombreUsuario();
        this.nombreCategoria = n.getNombreCategoria().getNombreCategoria();
        this.localizacion =n.getLocalizacion();
       
        ComentarioREST cr = new ComentarioREST();
        GenericType<List<Comentario>> gc = new GenericType<List<Comentario>>(){};
        List<Comentario> list = cr.findAll_XML(gc);
        
        for(Comentario c: list){
            if(c.getIdNoticia().getIdNoticia().equals(idNoticia)){
                listaComentarios.add(c);
            }
        }
        return SUCCESS;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

}
