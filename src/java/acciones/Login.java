/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.UsuarioREST;


/**
 *
 * @author Juanma
 */
public class Login extends ActionSupport {
    
    String usuario;
    String password;
    String mensajeError;
     
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public Login() {
    }
    
    public String execute() throws Exception {
        boolean error = false;
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>(){};
        Usuario u = null;
          
        CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        
        
        try{ 
            u = ur.find_XML(gt, usuario);
        }catch(javax.ws.rs.InternalServerErrorException E){
            error = true;
            mensajeError = "Internal server error: contactar con el admin";
        }catch(javax.ws.rs.NotFoundException E){
            error = true;
            mensajeError = "El usuario no existe";
        }
       
                
        
        if(!error && u == null){
            error = true;
            mensajeError = "El usuario no existe";
        }
        
        if (error) {
            return ERROR;
        } else {
            if (password.equals(u.getPassword())) {
                Map session = (Map) ActionContext.getContext().get("session");
                session.put("usuario", usuario);
                session.put("rol", u.getRol());
                session.put("categoria","portada");
                return SUCCESS;
            } else {
                mensajeError = "La contraseña no coincide";
                return ERROR;
            }
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    
    
    
}
