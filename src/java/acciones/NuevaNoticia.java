/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import classes.Noticia;
import classes.Tag;
import classes.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;
import persistencia.TagREST;
import persistencia.UsuarioREST;

/**
 *
 * @author Juanma
 */
public class NuevaNoticia extends ActionSupport {
    
    String tag;
    String imagen;
    String tituloNoticia;
    String subtituloNoticia;
    String cuerpoNoticia;
    String categoria;
    Integer historia;
    String usuario;
    String localizacion;
    Date fecha;
    
    public NuevaNoticia() {
    }
    
    public String execute() throws Exception {
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>(){};
         Map session = (Map) ActionContext.getContext().get("session");
        Usuario u = ur.find_XML(gt, (String)session.get("usuario"));
        
        CategoriaREST cr = new CategoriaREST();
        GenericType<Categoria> gt2 = new GenericType<Categoria>(){};
        Categoria c = cr.find_XML(gt2, categoria);

        fecha = new Date();
        Noticia n = new Noticia();
        n.setTituloNoticia(tituloNoticia);
        n.setSubtituloNoticia(subtituloNoticia);
        n.setCuerpoNoticia(cuerpoNoticia);
        n.setImagen(imagen);
        n.setLocalizacion(localizacion);
        n.setFechaNoticia(fecha);
        n.setNombreUsuario(u);
        n.setNombreCategoria(c);
        n.setIdHistoria(null);
        
        if(historia.intValue() != -1){
            HistoriaREST hr = new HistoriaREST();
            GenericType<Historia> gt3 = new GenericType<Historia>(){};
            Historia h = hr.find_XML(gt3, historia.toString());
            n.setIdHistoria(h);
        }
        
        NoticiaREST nr = new NoticiaREST();
        GenericType<List<Noticia>> gt4 = new GenericType<List<Noticia>>(){};
        nr.create_XML(n);
        
        List<Noticia> noticias = nr.findAll_XML(gt4);
        Noticia n2 = null;
        for(Noticia no : noticias){
            if(no.getTituloNoticia().equals(tituloNoticia)){
                n2 = no;
            }
        }
        
        TagREST tr = new TagREST();
        GenericType<Tag> gt5 = new GenericType<Tag>(){};
 
        String[] tags = tag.split(" ");
        for(String t : tags){
            Tag tg = new Tag();
            tg.setIdNoticia(n2);
            tg.setNombreTag(t);
            tr.create_XML(tg);
        }
        return SUCCESS;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getSubtituloNoticia() {
        return subtituloNoticia;
    }

    public void setSubtituloNoticia(String subtituloNoticia) {
        this.subtituloNoticia = subtituloNoticia;
    }

    public String getCuerpoNoticia() {
        return cuerpoNoticia;
    }

    public void setCuerpoNoticia(String cuerpoNoticia) {
        this.cuerpoNoticia = cuerpoNoticia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getHistoria() {
        return historia;
    }

    public void setHistoria(Integer historia) {
        this.historia = historia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

}
