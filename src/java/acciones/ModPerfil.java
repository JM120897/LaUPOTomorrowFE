/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.UsuarioREST;

/**
 *
 * @author ferna
 */
public class ModPerfil extends ActionSupport {
    
   public ModPerfil() {
    }

    private String nombreUsuario;
    private String password;
    private String nombreReal;
    private String email;
    private String localizacion;
    private String rol;

    public String execute() throws Exception {
        UsuarioREST ur = new UsuarioREST();
       
    
      
      
        Usuario usu = new Usuario();
        usu.setEmail(email);
        usu.setLocalizacion(localizacion);
        usu.setNombreReal(nombreReal);
        usu.setNombreUsuario(nombreUsuario);
        usu.setPassword(password);
        usu.setRol(rol);
        ur.edit_XML(usu, nombreUsuario);

        return SUCCESS;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}
