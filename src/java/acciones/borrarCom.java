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
import persistencia.ComentarioREST;

/**
 *
 * @author ferna
 */
public class borrarCom extends ActionSupport {
    
    
    Integer idNoticia2;
    Integer idNoticia = idNoticia2;
    Integer idComentario;
    public borrarCom() {
    }
    
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    public String execute() throws Exception {
        ComentarioREST cr= new ComentarioREST();
        cr.remove(idComentario.toString());    
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        return SUCCESS;
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

    public Integer getIdNoticia2() {
        return idNoticia2;
    }

    public void setIdNoticia2(Integer idNoticia2) {
        this.idNoticia2 = idNoticia2;
    }
    
}
