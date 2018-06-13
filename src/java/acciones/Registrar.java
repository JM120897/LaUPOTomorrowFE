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
public class Registrar extends ActionSupport {

    String nombre_usuario;
    String password;
    String email;
    String nombre_real;
    String localizacion;
    String mensajeError;
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public Registrar() {

    }

    public String execute() throws Exception {
        boolean error = false;
        Usuario u1 = new Usuario();
        u1.setNombreUsuario(nombre_usuario);
        u1.setPassword(password);
        u1.setNombreReal(nombre_real);
        u1.setEmail(email);
        u1.setLocalizacion(localizacion);
        u1.setRol("lector");
        Usuario u2 = null;

        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);

        //Primero hay que ver si no existe el usuario ya
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>() {
        };
        try {
            //Consume el servicio REST para encontrar un usuario segun su nombre de usuario
            u2 = ur.find_XML(gt, nombre_usuario);
        } catch (javax.ws.rs.InternalServerErrorException E) {
            error = true;
            mensajeError = "Internal server error: contactar con el admin";
        } catch (javax.ws.rs.NotFoundException E) {
            error = true;
            mensajeError = "El usuario no existe";
        }

        if (u2 != null) {
            error = true;
            mensajeError = "Ese usuario ya existe";
        }

        if (error) {

            return ERROR;

        } else {

            try {
                //Consume el servicio REST para crear un nuevo usuario
                ur.create_XML(u1);
            } catch (javax.ws.rs.InternalServerErrorException E) {
                error = true;
                mensajeError = "Internal server error: contactar con el admin";
            } catch (javax.ws.rs.NotFoundException E) {
                error = true;
                mensajeError = "El usuario no existe";
            }

            if (!error) {
                return SUCCESS;
            } else {
                return ERROR;
            }

        }

    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public void setNombre_real(String nombre_real) {
        this.nombre_real = nombre_real;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}
