/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;

/**
 *
 * @author ferna
 */
public class Logout extends ActionSupport {

    List<Categoria> listaCategoriaMenu = new ArrayList();

    public Logout() {
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", null);
        session.put("rol", null);

        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);

        return SUCCESS;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

}
