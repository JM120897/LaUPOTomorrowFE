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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.NoticiaREST;
import persistencia.NotificacionREST;

/**
 *
 * @author ferna
 */
public class cambiarCategoriaIndex extends ActionSupport {

    List<Categoria> categorias;
    String categoria;
    List<Noticia> lista;
    List<Noticia> coincidencias = new ArrayList();
    List<Notificacion> list = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;
    List<Categoria> listaCat = new ArrayList();
    List<Categoria> listaCategoriaMenu = new ArrayList();
    String nombreCategoria;

    public cambiarCategoriaIndex() {
    }

    public String execute() throws Exception {
        Map s = (Map) ActionContext.getContext().get("session");
        String ca = nombreCategoria;
        s.put("categoria", nombreCategoria);
        NoticiaREST nor = new NoticiaREST();
        GenericType<List<Noticia>> gt3 = new GenericType<List<Noticia>>() {
        };
        //Consume el servicio REST para coger todas las noticias
        lista = nor.findAll_XML(gt3);

        lista.sort(new Comparator<Noticia>() {
            public int compare(Noticia o1, Noticia o2) {
                return o2.getFechaNoticia().compareTo(o1.getFechaNoticia());
            }
        });

        CategoriaREST cr = new CategoriaREST();
        GenericType<List<Categoria>> gt2 = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        categorias = cr.findAll_XML(gt2);

        NotificacionREST nr = new NotificacionREST();
        GenericType<List<Notificacion>> gt = new GenericType<List<Notificacion>>() {
        };
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        Map session = (Map) ActionContext.getContext().get("session");
        //Consume el servicio REST para coger todas las notificaciones
        list = nr.findAll_XML(gt);
        for (Notificacion n : list) {
            if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(n);
            }

        }
        numNoti = listaNotifi.size();

        for (Noticia n : lista) {
            if (n.getNombreCategoria() != null && n.getNombreCategoria().getNombreCategoria().equals((String) s.get("categoria"))) {
                coincidencias.add(n);
            }
        }

        return SUCCESS;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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

    public List<Noticia> getLista() {
        return lista;
    }

    public void setLista(List<Noticia> lista) {
        this.lista = lista;
    }

    public List<Noticia> getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(List<Noticia> coincidencias) {
        this.coincidencias = coincidencias;
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

    public List<Categoria> getListaCat() {
        return listaCat;
    }

    public void setListaCat(List<Categoria> listaCat) {
        this.listaCat = listaCat;
    }

}
