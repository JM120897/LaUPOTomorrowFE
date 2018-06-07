/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.HibernateUtil;
import classes.Historia;
import java.util.List;
import javax.jws.WebMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna
 */
public class FachadaHistoria {
    
    public void addHistoria(Historia Hist) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(Hist);
        t.commit();
          s.close();
    }

    
    public void updateHistoria(Historia Hist) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(Hist);
        t.commit();
          s.close();
    }

   
    public List<Historia> listHistoria() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Historia");
        List<Historia> l = q.list();
        t.commit();
          s.close();
        return l;
    }

  
    public void deleteHistoria(Historia Hist) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(Hist);
        t.commit();
          s.close();
    }

    
    public Historia readHistoria(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Historia where id_historia ='" + id + "'");
        Historia Hist = (Historia) q.uniqueResult();
        t.commit();
          s.close();
        return Hist;
    }
}
