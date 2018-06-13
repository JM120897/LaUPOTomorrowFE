/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.NoticiaREST;

/**
 *
 * @author ferna
 */
public class BorrarNoticia extends ActionSupport {

    Integer idNoticia;
    List<Categoria> listaCategoria = new ArrayList();

    public BorrarNoticia() {
    }

    public String execute() throws Exception {
        NoticiaREST nr = new NoticiaREST();

        //Consume el servicio REST para eliminar una noticia
        nr.remove(idNoticia.toString());

        CategoriaREST cr = new CategoriaREST();
        GenericType<List<Categoria>> gc = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categoria
        listaCategoria = cr.findAll_XML(gc);

        return SUCCESS;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
}
