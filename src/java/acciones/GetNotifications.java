/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import classes.Notificacion;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import persistencia.NotificacionREST;

/**
 *
 * @author Juanma
 */
public class GetNotifications {

    static int calcularNotificaciones() {

        Map sessionnotifi = (Map) ActionContext.getContext().get("session");
        NotificacionREST notifir = new NotificacionREST();
        GenericType<List<Notificacion>> gtnotificaciones = new GenericType<List<Notificacion>>() {};
        List<Notificacion>listNot = notifir.findAll_XML(gtnotificaciones);
        List<Notificacion> listaNotifi = new ArrayList<>();
        for (Notificacion notificacion : listNot) {
            if (notificacion.getNombreUsuario().getNombreUsuario().equals(sessionnotifi.get("usuario"))) {
                listaNotifi.add(notificacion);   
            }

        }
        return listaNotifi.size();
    }
    
    
    
}
