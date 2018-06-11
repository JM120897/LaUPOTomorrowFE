/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import classes.Noticia;
import classes.Notificacion;
import classes.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;
import persistencia.NotificacionREST;
import persistencia.UsuarioREST;

/**
 *
 * @author ferna
 */
public class IrPerfil extends ActionSupport {

    public IrPerfil() {
    }

    String nombreUsuario;
    String password;
    String nombreReal;
    String email;
    String localizacion;
    String rol;
    List<Noticia> listaNoticia = new ArrayList<Noticia>();
     List<Historia> listaHistoriasUsuario = new ArrayList();
     
    List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public String execute() throws Exception {

        Map session = (Map) ActionContext.getContext().get("session");
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>() {
        };
        Usuario usu;
        usu = ur.find_XML(gt, (String) session.get("usuario"));
 CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        nombreUsuario = usu.getNombreUsuario();
        nombreReal = usu.getNombreReal();
        email = usu.getEmail();
        localizacion = usu.getLocalizacion();
        rol = usu.getRol();

        if (session.get("rol").equals("redactor")) {
            List<Noticia> l;
            NoticiaREST nr = new NoticiaREST();
            GenericType<List<Noticia>> gtn = new GenericType<List<Noticia>>(){};
            l = nr.findAll_XML(gtn);
            Iterator<Noticia> it = l.iterator();
           
            while (it.hasNext()) {
                Noticia n = it.next();
               
                if (n.getNombreUsuario() != null && n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                    
                    listaNoticia.add(n);
                }
            }

            List<Historia> listaHistoria;
            HistoriaREST hr = new HistoriaREST();
            GenericType<List<Historia>> gth = new GenericType<List<Historia>>(){};
            listaHistoria=hr.findAll_XML(gth);
            
            for(Historia h: listaHistoria){
                if(h.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))){
                    listaHistoriasUsuario.add(h);
                }
            }
            
        }
       Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {
        };
        listNot = notifir.findAll_XML(gtnotificaciones);
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equals(sessionnotifi.get("usuario"))) {
                listaNotifi.add(notificacion);
            }

        }
        numNoti = listaNotifi.size();
       
        
        
        return SUCCESS;
    }
    
    /////////////////
      List<Notificacion> listNot = new ArrayList();
    List<Notificacion> listaNotifi = new ArrayList();
    int numNoti = 0;
    
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
     public List<Notificacion> getListNot() {
        return listNot;
    }

    public void setList(List<Notificacion> listNot) {
        this.listNot = listNot;
    }

    public List<Historia> getListaHistoriasUsuario() {
        return listaHistoriasUsuario;
    }

    public void setListaHistoriasUsuario(List<Historia> listaHistoriasUsuario) {
        this.listaHistoriasUsuario = listaHistoriasUsuario;
    }

    

    public List<Noticia> getListaNoticia() {
        return listaNoticia;
    }

    public void setListaNoticia(List<Noticia> listaNoticia) {
        this.listaNoticia = listaNoticia;
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
