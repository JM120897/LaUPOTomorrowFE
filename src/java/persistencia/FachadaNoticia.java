/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.HibernateUtil;
import classes.Noticia;
import java.util.List;
import javax.jws.WebMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna
 */
public class FachadaNoticia {
    public void addNoticia(Noticia Not) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(Not);
        t.commit();
          s.close();
    }

    
    public void updateNoticia(Noticia Not) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(Not);
        t.commit();
          s.close();
    }

    public List<Noticia> listNoticia() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Noticia");
        List<Noticia> l = q.list();
        t.commit();
          s.close();
        return l;
    }

   
    public void deleteNoticia(Noticia Not) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(Not);
        t.commit();
          s.close();
    }

    
    public Noticia readNoticia(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Noticia where id_noticia ='" + id + "'");
        Noticia Not = (Noticia) q.uniqueResult();
        t.commit();
          s.close();
        return Not;
    }
}
