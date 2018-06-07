/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Categoria;
import classes.HibernateUtil;
import java.util.List;
import javax.jws.WebMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna
 */
public class FachadaCategoria {
   
    public void addCategoria(Categoria cat) {
        Session s  = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(cat);
        t.commit();
          s.close();
    }
    
   
    public void updateCategoria(Categoria cat) {
        Session s  = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(cat);
        t.commit();
          s.close();
    }
      
    public List<Categoria> listCategoria() {
        Session s  = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Categoria");
        List<Categoria> l = q.list();
        t.commit();
          s.close();
        return l;
    }
   
   public void deleteCategoria(Categoria cat) {
        Session s  = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(cat);
        t.commit();
          s.close();
    }
}
