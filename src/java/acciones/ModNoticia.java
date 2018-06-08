/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Noticia;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import persistencia.NoticiaREST;

/**
 *
 * @author ferna
 */
public class ModNoticia extends ActionSupport {
    
    public ModNoticia() {
    }
    
     String idNoticia;
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
    
    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();
        Noticia n = new Noticia();
        n.setCuerpoNoticia(cuerpoNoticia);
        n.setFechaNoticia(fechaNoticia);
        n.setIdNoticia(Integer.parseInt(idNoticia));
        n.setImagen(imagen);
        n.setLocalizacion(localizacion);
      
        n.setSubtituloNoticia(subtituloNoticia);
        n.setTituloNoticia(tituloNoticia);
        return SUCCESS;
    }

    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
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

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
}
