/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Noticia;
import classes.Tag;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import persistencia.FachadaNoticia;

/**
 *
 * @author Juanma
 */
public class Busqueda extends ActionSupport {
    
    String busqueda;
    String mensajeError;
    List<Noticia> coincidencias;
    
    public Busqueda() {
    }
    
    public String execute() throws Exception {
        boolean error = false;
        FachadaNoticia fn = new FachadaNoticia();
        List<Noticia> noticias = fn.listNoticia();
        coincidencias = new ArrayList<>();
        addCoincidencias(coincidencias, noticias);
        if(coincidencias.size() == 0){
            mensajeError = "No se encontraron noticias relacionadas con su búsqueda";
            error = true;
        }else{
            
        }
        if(!error){
            return SUCCESS;
        }else{
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

    public void setCoincidencias(List<Noticia> coincidencias) {
        this.coincidencias = coincidencias;
    }

    private void addCoincidencias(List<Noticia> coincidencias, List<Noticia> noticias) {
        String[] params = busqueda.split(" ");
        for(Noticia n : noticias){
            for(String param : params){
                if(n.getTituloNoticia().contains(param)){
                    coincidencias.add(n);
                }
                Set<Tag> s = n.getTags();
                for(Tag t : s){
                    if(!coincidencias.contains(n) && param.equalsIgnoreCase(t.getNombreTag())){
                        coincidencias.add(n);
                    }
                }
            }
        }
    }
    
    
    
    
}
