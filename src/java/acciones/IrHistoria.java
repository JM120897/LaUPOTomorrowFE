/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import classes.Noticia;
import classes.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;

/**
 *
 * @author ferna
 */
public class IrHistoria extends ActionSupport {
    
    public IrHistoria() {
    }
    
    Integer idHistoria;
    String tituloHistoria;
     String subtituloHistoria;
     Date fechaHistoria;
     String nombreUsuario;
      List<Noticia> listNoticias = new ArrayList();
      List<Noticia> listaNoticiasHistoria = new ArrayList();
       List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    public String execute() throws Exception {
         
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        Historia h = new Historia();
        HistoriaREST hr = new HistoriaREST();
        GenericType<Historia> gh = new GenericType<Historia>(){};
        h=hr.find_XML(gh, idHistoria.toString());
        tituloHistoria=h.getTituloHistoria();
        subtituloHistoria = h.getSubtituloHistoria();
        fechaHistoria= h.getFechaHistoria();
        NoticiaREST nr = new NoticiaREST();
       GenericType<List<Noticia>> gn = new GenericType<List<Noticia>>(){};
       listNoticias = nr.findAll_XML(gn);
       for(Noticia n :listNoticias){
           if(n.getIdHistoria().getIdHistoria().equals(idHistoria)){
               listaNoticiasHistoria.add(n);
           }
       }
       nombreUsuario=h.getNombreUsuario().getNombreUsuario();
       return SUCCESS;
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
