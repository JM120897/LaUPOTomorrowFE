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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;
import persistencia.UsuarioREST;
import persistencia.TagREST;

/**
 *
 * @author ferna
 */
public class ModNoticia extends ActionSupport {

    public ModNoticia() {
    }

    Integer idNoticia;
    String tituloNoticia;
    String subtituloNoticia;

    Categoria categoria;
    String nombreCategoria;

    Integer historia;
    Historia h;

    String nombreUsuario;
    Date fechaNoticia;
    String imagen;
    String cuerpoNoticia;

    String tag;

    String tags;

    String localizacion;
  
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();
        Map session = (Map) ActionContext.getContext().get("session");
        Noticia n = new Noticia();
        n.setIdNoticia(idNoticia);
        n.setTituloNoticia(tituloNoticia);
        n.setSubtituloNoticia(subtituloNoticia);

        CategoriaREST cr = new CategoriaREST();
        GenericType<Categoria> gt2 = new GenericType<Categoria>(){};
        Categoria c = cr.find_XML(gt2, nombreCategoria);
         
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        
        
        n.setNombreCategoria(c);

        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>() {
        };
        Usuario usu;
        usu = ur.find_XML(gt, (String) session.get("usuario"));
        n.setNombreUsuario(usu);
      
        n.setFechaNoticia(fechaNoticia);
        n.setCuerpoNoticia(cuerpoNoticia);
        n.setImagen(imagen);

        n.setLocalizacion(localizacion);

        if (historia != -1) {
            HistoriaREST hr = new HistoriaREST();
            GenericType<Historia> gh = new GenericType<Historia>() {
            };
            Historia h = hr.find_XML(gh, historia.toString());
            n.setIdHistoria(h);
        } else {
            n.setIdHistoria(null);
        }
       
        nr.edit_XML(n, idNoticia.toString());
        
        TagREST tar = new TagREST();
        GenericType<List<Tag>> glt = new GenericType<List<Tag>>() {
        };
        List<Tag> lt = new ArrayList();
        lt = tar.findAll_XML(glt);
        List<Tag> tagsNoticia = new ArrayList();
        for(Tag t: lt){
            if(t.getIdNoticia().getIdNoticia()==idNoticia){
                tagsNoticia.add(t);
            }
        }
        
        for(Tag te:tagsNoticia){
            tar.remove(te.getIdTag().toString());
        }
        
        String[] listaTags = tags.split(" ");
       for(String tag: listaTags){
           Tag taga = new Tag();
           taga.setIdNoticia(n);
           taga.setNombreTag(tag);
           tar.create_XML(taga);
       }
           
            
        

        return SUCCESS;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getHistoria() {
        return historia;
    }

    public void setHistoria(Integer historia) {
        this.historia = historia;
    }

    public Historia getH() {
        return h;
    }

    public void setH(Historia h) {
        this.h = h;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
