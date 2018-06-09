/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Historia;
import classes.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import persistencia.HistoriaREST;

/**
 *
 * @author ferna
 */
public class IrModHistoria extends ActionSupport {
    
    public IrModHistoria() {
    }
     Integer idHistoria;
    String tituloHistoria;
     String subtituloHistoria;
     Date fechaHistoria;
     String nombreUsuario;
    public String execute() throws Exception {
        Historia h = new Historia();
        HistoriaREST hr = new HistoriaREST();
        GenericType<Historia> gh = new GenericType<Historia>(){};
        h=hr.find_XML(gh, idHistoria.toString());
        tituloHistoria=h.getTituloHistoria();
        subtituloHistoria = h.getSubtituloHistoria();
        fechaHistoria= h.getFechaHistoria();
        nombreUsuario=h.getNombreUsuario().getNombreUsuario();
        idHistoria= h.getIdHistoria();
        return SUCCESS;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
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

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
}
