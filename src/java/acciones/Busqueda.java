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
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;
import persistencia.TagREST;

/**
 *
 * @author Juanma
 */
public class Busqueda extends ActionSupport {

    String categoria;
    String busqueda;
    String mensajeError;
    List<Noticia> coincidencias;
    List<Historia> coincidenciasHistoria;
    List<Categoria> listaCategoriaMenu = new ArrayList<>();

    public List<Historia> getCoincidenciasHistoria() {
        return coincidenciasHistoria;
    }

    public void setCoincidenciasHistoria(List<Historia> coincidenciasHistoria) {
        this.coincidenciasHistoria = coincidenciasHistoria;
    }

    
    
    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public Busqueda() {
    }

    public String execute() throws Exception {
        boolean error = false;
        NoticiaREST nr = new NoticiaREST();
        GenericType<List<Noticia>> gt = new GenericType<List<Noticia>>() {};
        List<Noticia> noticias = null;
         CategoriaREST cr = new CategoriaREST();
         GenericType<List<Categoria>> gc = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = cr.findAll_XML(gc);
        HistoriaREST hr = new HistoriaREST();
        GenericType<List<Historia>> gh = new GenericType<List<Historia>>() {};
        List<Historia> historias = hr.findAll_XML(gh);
        
        coincidenciasHistoria = new ArrayList<>();
   
        try {
            noticias = nr.findAll_XML(gt);
        } catch (javax.ws.rs.InternalServerErrorException E) {
            error = true;
            mensajeError = "Internal server error: contactar con el admin";
        } catch (javax.ws.rs.NotFoundException E) {
            error = true;
            mensajeError = "ERROR 404";
        }
        if (!error) {
            coincidencias = new ArrayList<>();
            addCoincidencias(coincidencias, noticias, coincidenciasHistoria, historias);
            if (coincidencias.size() == 0) {
                mensajeError = "No se encontraron noticias relacionadas con su búsqueda";
                error = true;
            }else if(coincidenciasHistoria.size() == 0){
                mensajeError += "\nNo se encontraron historias relacionadas con su búsqueda";
                error = true;
            } else {
                //ORDENAR POR FECHA.
                coincidencias.sort(new Comparator<Noticia>() {
                    public int compare(Noticia o1, Noticia o2) {
                        return o2.getFechaNoticia().compareTo(o1.getFechaNoticia());
                    }
                });
                
                coincidenciasHistoria.sort(new Comparator<Historia>() {
                    public int compare(Historia o1, Historia o2) {
                        return o2.getFechaHistoria().compareTo(o1.getFechaHistoria());
                    }
                });
            }
        }
        if (!error) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String search) {
        this.busqueda = search;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public List<Noticia> getCoincidencias() {
        return coincidencias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCoincidencias(List<Noticia> coincidencias) {
        this.coincidencias = coincidencias;
    }

    private void addCoincidencias(List<Noticia> coincidencias, List<Noticia> noticias, List<Historia> coincidenciasHistoria, List<Historia> historias) {

        String[] params = busqueda.split(" ");
        for (Noticia n : noticias) {
            for (String param : params) {
                if (!coincidencias.contains(n) && n.getTituloNoticia().toLowerCase().contains(param.toLowerCase())) {
                    if(categoria == null){
                        coincidencias.add(n);
                    }else if(categoria != null && n.getNombreCategoria().getNombreCategoria().equalsIgnoreCase(categoria)){
                        coincidencias.add(n);
                    }
                }
                TagREST tr = new TagREST();
                GenericType<List<Tag>> gt = new GenericType<List<Tag>>(){};
                List<Tag> l = tr.findAll_XML(gt);
                for(Tag t : l){
                    if(!coincidencias.contains(n) && t.getIdNoticia().getIdNoticia() == n.getIdNoticia() && t.getNombreTag().equalsIgnoreCase(param)){
                        if(categoria == null){
                        coincidencias.add(n);

                        }else if(categoria != null && n.getNombreCategoria().getNombreCategoria().equalsIgnoreCase(categoria)){
                            coincidencias.add(n);
                        }
                    }
                }
            }
        }
        
        if(categoria == null){
            for(Historia h : historias){
                for(String param : params){
                    if(h.getTituloHistoria().toLowerCase().contains(param.toLowerCase())){
                            coincidenciasHistoria.add(h);
                    }
                }   
            }
        }
        
    }

}
