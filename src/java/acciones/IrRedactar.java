/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;

/**
 *
 * @author Juanma
 */
public class IrRedactar extends ActionSupport {
    
    List<Categoria> categorias;
    List<Historia> historias;
 
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public IrRedactar() {
        
    }
    
    public String execute() throws Exception {
        GenericType<List<Categoria>> gt = new GenericType<List<Categoria>>(){};
        CategoriaREST cr = new CategoriaREST();
        GenericType<List<Historia>> gt2 = new GenericType<List<Historia>>(){};
        HistoriaREST hr = new HistoriaREST();
         
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        categorias = cr.findAll_XML(gt);
        historias = hr.findAll_XML(gt2);
        return SUCCESS;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Historia> getHistorias() {
        return historias;
    }

    public void setHistorias(List<Historia> historias) {
        this.historias = historias;
    }
    
    
    
}
