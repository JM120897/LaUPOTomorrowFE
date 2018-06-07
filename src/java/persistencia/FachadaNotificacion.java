/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.HibernateUtil;
import classes.Notificacion;
import classes.Usuario;
import java.util.List;
import javax.jws.WebMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna
 */
public class FachadaNotificacion {
   
    public void addNotificacion(Notificacion Notf) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(Notf);
        t.commit();
          s.close();
    }

    
    public void updateNotificacion(Notificacion Notf) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(Notf);
        t.commit();
          s.close();
    }

    
    public List<Notificacion> listNotificacion(Usuario u) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Notificacion where nombre_usuario='"+u.getNombreUsuario()+"'");
        List<Notificacion> l = q.list();
        t.commit();
          s.close();
        return l;
    }

    
    public void deleteNotificacion(Notificacion Notf) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(Notf);
          s.close();
        t.commit();
    }

   
    public Notificacion readNotificacion(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();;
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Notificacion where id_notificacion ='" + id + "'");
        Notificacion Notf = (Notificacion) q.uniqueResult();
        t.commit();
          s.close();
        return Notf;
    }
}
