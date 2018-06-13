/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Notificacion;
import classes.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.NotificacionREST;
import persistencia.UsuarioREST;

/**
 *
 * @author ferna
 */
public class IrModPerfil extends ActionSupport {

    private String nombreUsuario;
    private String password;
    private String nombreReal;
    private String email;
    private String localizacion;
    private String rol;
    List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public IrModPerfil() {
    }

    public String execute() throws Exception {
        CategoriaREST categoriar = new CategoriaREST();
        GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>() {
        };
        //Consume el servicio REST para coger todas las categorias
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);

        UsuarioREST ur = new UsuarioREST();
        Map session = (Map) ActionContext.getContext().get("session");
        GenericType<Usuario> gt = new GenericType<Usuario>() {
        };
        Usuario usu;
        //Consume el servicio REST para encontrar un usuario según su nombre de usuario
        usu = ur.find_XML(gt, (String) session.get("usuario"));
        nombreUsuario = usu.getNombreUsuario();
        nombreReal = usu.getNombreReal();
        email = usu.getEmail();
        localizacion = usu.getLocalizacion();
        rol = usu.getRol();
        password = usu.getPassword();

        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotifi = new GenericType<List<Notificacion>>() {
        };
        //Consume el servicio REST para coger todas las notificaciones
        listNot = notifir.findAll_XML(gtnotifi);
        for (Notificacion n : listNot) {
            if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                listaNotifi.add(n);
            }

        }
        numNoti = listaNotifi.size();

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

    public List<Notificacion> getListNot() {
        return listNot;
    }

    public void setList(List<Notificacion> listNot) {
        this.listNot = listNot;
    }

    public List<Notificacion> getListaNotifi() {
        return listaNotifi;
    }

    public void setListaNotifi(List<Notificacion> listaNotifi) {
        this.listaNotifi = listaNotifi;
    }

    public int getNumNoti() {
        return numNoti;
    }

    public void setNumNoti(int numNoti) {
        this.numNoti = numNoti;
    }

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }

}
