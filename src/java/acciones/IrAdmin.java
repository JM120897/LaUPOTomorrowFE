/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.UsuarioREST;

/**
 *
 * @author Juanma
 */
public class IrAdmin extends ActionSupport {
    
    List<Categoria> categorias;
    List<Usuario> usuarios;
    
    public IrAdmin() {
        
    }
    
    public String execute() throws Exception {
        CategoriaREST cr = new CategoriaREST();
        GenericType<List<Categoria>> gt = new GenericType<List<Categoria>>(){};
        categorias = cr.findAll_XML(gt);
        
        UsuarioREST ur = new UsuarioREST();
        GenericType<List<Usuario>> gt2 = new GenericType<List<Usuario>>(){};
        usuarios = ur.findAll_XML(gt2);
        
        return SUCCESS;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}