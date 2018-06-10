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
    List<Noticia> coincidencias;
    
    public Indice() {

    }
    
    List<Notificacion> list = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;

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
        
        NotificacionREST nr = new NotificacionREST();
        GenericType<List<Notificacion>> gt = new GenericType<List<Notificacion>>() {
        };
        Map session = (Map) ActionContext.getContext().get("session");
        list = nr.findAll_XML(gt);
        for (Notificacion n : list) {
            if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(n);
            }

        }
        numNoti = listaNotifi.size();
        return SUCCESS;
    }
    
    public String cambiarCategoria() throws Exception {
        NoticiaREST nor = new NoticiaREST();
        GenericType<List<Noticia>> gt3 = new GenericType<List<Noticia>>(){};
        List<Noticia> noticias = nor.findAll_XML(gt3);
        coincidencias = new ArrayList<>();
        
        for(Noticia n : noticias){
            if(n.getNombreCategoria().getNombreCategoria()!= null && n.getNombreCategoria().getNombreCategoria().equals(categoria)){
                coincidencias.add(n);
            }
        }
        
        coincidencias.sort(new Comparator<Noticia>() {
                    public int compare(Noticia o1, Noticia o2) {
                        return o2.getFechaNoticia().compareTo(o1.getFechaNoticia());
                    }
                });
        
        return SUCCESS;
    }

    public List<Notificacion> getList() {
        return list;
    }

    public void setList(List<Notificacion> list) {
        this.list = list;
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
