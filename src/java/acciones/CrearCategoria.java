/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;

/**
 *
 * @author Juanma
 */
public class CrearCategoria extends ActionSupport {

    String nombreCategoria;
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public CrearCategoria() {
    }

    public String execute() throws Exception {
        Categoria c = new Categoria(nombreCategoria);

        CategoriaREST cr = new CategoriaREST();
        //Consume el servicio REST para crear una categoria
        cr.create_XML(c);
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        return SUCCESS;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

}
