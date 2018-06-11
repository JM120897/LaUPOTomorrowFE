/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Noticia;
import classes.Notificacion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.NoticiaREST;


import persistencia.NotificacionREST;

/**
 *
 * @author Juanma
 */
public class Indice extends ActionSupport {

    List<Categoria> categorias;
    String categoria;
    List<Noticia> lista;
    List<Noticia> coincidencias; 
  
   
    List<Categoria> listaCat = new ArrayList();
    List<Categoria> listaCategoriaMenu = new ArrayList();

   
    public Indice() {

    }
   
    public String execute() throws Exception {
        
        NoticiaREST nor = new NoticiaREST();
        GenericType<List<Noticia>> gt3 = new GenericType<List<Noticia>>(){};
        coincidencias = nor.findAll_XML(gt3);
        
        coincidencias.sort(new Comparator<Noticia>() {
                    public int compare(Noticia o1, Noticia o2) {
                        return o2.getFechaNoticia().compareTo(o1.getFechaNoticia());
                    }
                });
        
        
        
        CategoriaREST cr = new CategoriaREST();
        GenericType<List<Categoria>> gt2 = new GenericType<List<Categoria>>(){};
        categorias = cr.findAll_XML(gt2);
        
       
         CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        /////
        Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {
        };
        listNot = notifir.findAll_XML(gtnotificaciones);
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equals(sessionnotifi.get("usuario"))) {
                listaNotifi.add(notificacion);
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
 public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
   

    

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Noticia> getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(List<Noticia> coincidencias) {
        this.coincidencias = coincidencias;
    }
    
    


}
