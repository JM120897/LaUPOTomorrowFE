/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import persistencia.HistoriaREST;

/**
 *
 * @author ferna
 */
public class BorrarHistoria extends ActionSupport {
    
    public BorrarHistoria() {
    }
    Integer idHistoria;
    public String execute() throws Exception {
      HistoriaREST hr = new HistoriaREST();
      hr.remove(idHistoria.toString());
      return SUCCESS;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }
    
}
