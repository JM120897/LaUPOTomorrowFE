/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Historia;
import classes.Noticia;
import classes.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.HistoriaREST;
import persistencia.NoticiaREST;
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
    
    public String execute() throws Exception {

        Map session = (Map) ActionContext.getContext().get("session");
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gt = new GenericType<Usuario>() {
        };
        Usuario usu;
        usu = ur.find_XML(gt, (String) session.get("usuario"));

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
               
                if (n.getNombreUsuario().getNombreUsuario().equals(session.get("usuario"))) {
                    
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
        return SUCCESS;
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
