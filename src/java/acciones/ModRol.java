/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
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
    
    public String execute() throws Exception {
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>(){};
        Usuario u = ur.find_XML(gt, nombreUsuario);
        
        u.setRol(rol);
        ur.edit_XML(u, nombreUsuario);
        
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
