/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.HibernateUtil;
import classes.Tag;
import java.util.List;
import javax.jws.WebMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna
 */
public class FachadaTag {
    public void addTag(Tag Tag) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(Tag);
        t.commit();
          s.close();
    }

  
    public void updateTag(Tag Tag) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(Tag);
        t.commit();
          s.close();
    }

    
    public List<Tag> listTag() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Tag");
        List<Tag> l = q.list();
        t.commit();
          s.close();
        return l;
    }

    
    public void deleteTag(Tag Tag) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(Tag);
        t.commit();
          s.close();
    }
   
}
