/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import persistencia.UsuarioREST;

import classes.Usuario;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Juanma
 */
public class BorrarPerfil extends ActionSupport {

    String nombreUsuario;

    public BorrarPerfil() {
    }

    public String execute() throws Exception {
        UsuarioREST ur = new UsuarioREST();
        //Consume el servicio REST para eliminar un usuario
        ur.remove(nombreUsuario);
        return SUCCESS;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
