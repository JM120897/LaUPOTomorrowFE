/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.UsuarioREST;

/**
 *
 * @author Juanma
 */
public class ModRol extends ActionSupport {
    
    String rol;
    String nombreUsuario;
    
    public ModRol() {
    }
     
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public String execute() throws Exception {
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>(){};
        Usuario u = ur.find_XML(gt, nombreUsuario);
        
        u.setRol(rol);
        ur.edit_XML(u, nombreUsuario);
          
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        
        return SUCCESS;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
}
