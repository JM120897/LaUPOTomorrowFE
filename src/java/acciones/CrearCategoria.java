/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;

/**
 *
 * @author Juanma
 */
public class CrearCategoria extends ActionSupport {
    
    String nombreCategoria;
    
    public CrearCategoria() {
    }
    
    public String execute() throws Exception {
        Categoria c = new Categoria(nombreCategoria);
        
        CategoriaREST cr = new CategoriaREST();
        cr.create_XML(c);
        
        return SUCCESS;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
}
