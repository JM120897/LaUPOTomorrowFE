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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.GenericType;
import persistencia.NoticiaREST;

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
        NoticiaREST nr = new NoticiaREST();
        GenericType<List<Noticia>> gt = new GenericType<List<Noticia>>() {
        };
        List<Noticia> noticias = null;
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
            addCoincidencias(coincidencias, noticias);
            if (coincidencias.size() == 0) {
                mensajeError = "No se encontraron noticias relacionadas con su búsqueda";
                error = true;
            } else {
                //ORDENAR POR FECHA.
                noticias.sort(new Comparator<Noticia>() {
                    public int compare(Noticia o1, Noticia o2) {
                        return o1.getFechaNoticia().compareTo(o2.getFechaNoticia());
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

    public void setCoincidencias(List<Noticia> coincidencias) {
        this.coincidencias = coincidencias;
    }

    private void addCoincidencias(List<Noticia> coincidencias, List<Noticia> noticias) {
        String[] params = busqueda.split(" ");
        for (Noticia n : noticias) {
            for (String param : params) {
                if (!coincidencias.contains(n) && n.getTituloNoticia().toLowerCase().contains(param.toLowerCase())) {
                    coincidencias.add(n);
                }
            }
        }
    }

}
