/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Categoria;
import classes.Historia;
import classes.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.CategoriaREST;
import persistencia.HistoriaREST;
import persistencia.UsuarioREST;

/**
 *
 * @author ferna
 */
public class CrearHistoria extends ActionSupport {

    public CrearHistoria() {
    }

    String tituloHistoria;
    String subtituloHistoria;
    String nombreUsuario;
    Integer idHistoria;
    Date fechaHistoria;
 List<Categoria> listaCategoriaMenu = new ArrayList();

    public List<Categoria> getListaCategoriaMenu() {
        return listaCategoriaMenu;
    }

    public void setListaCategoriaMenu(List<Categoria> listaCategoriaMenu) {
        this.listaCategoriaMenu = listaCategoriaMenu;
    }
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        nombreUsuario = (String) session.get("usuario");
        Historia h = new Historia();
        h.setFechaHistoria(new Date());
        UsuarioREST ur = new UsuarioREST();
        GenericType<Usuario> gu = new GenericType<Usuario>(){};
        Usuario usu = ur.find_XML(gu, nombreUsuario);
        h.setNombreUsuario(usu);
        h.setSubtituloHistoria(subtituloHistoria);
        h.setTituloHistoria(tituloHistoria);
 CategoriaREST categoriar = new CategoriaREST();
         GenericType<List<Categoria>> genericCat = new GenericType<List<Categoria>>(){};
        listaCategoriaMenu = categoriar.findAll_XML(genericCat);
        HistoriaREST hr = new HistoriaREST();
        hr.create_XML(h);
        return SUCCESS;
    }

    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }

    public String getSubtituloHistoria() {
        return subtituloHistoria;
    }

    public void setSubtituloHistoria(String subtituloHistoria) {
        this.subtituloHistoria = subtituloHistoria;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

}
