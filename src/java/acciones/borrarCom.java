/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Comentario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.ComentarioREST;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author ferna
 */
public class borrarCom extends ActionSupport {

    Integer idNoticia;
    Integer idComentario;

    public borrarCom() {
    }

    public String execute() throws Exception {

        ComentarioREST cr = new ComentarioREST();
        GenericType<Comentario> gc = new GenericType<Comentario>() {
        };
        //Consume el servicio REST para encontrar un comentario segun su id
        Comentario c = cr.find_XML(gc, idComentario.toString());
        idNoticia = c.getIdNoticia().getIdNoticia();
        //Consume el servicio REST para eliminar un comentario
        cr.remove(idComentario.toString());
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);

        return SUCCESS;
    }

    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

}
