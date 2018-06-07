/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.HibernateUtil;
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
public class FachadaUsuario {
   
    public void addUsuario(Usuario Usu) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(Usu);
        t.commit();
          s.close();
    }

  
    public void updateUsuario(Usuario Usu) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(Usu);
        t.commit();
          s.close();
    }

   

    
    public List<Usuario> listar() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Usuario");
        List<Usuario> l = q.list();
        t.commit();
          s.close();
        return l;
                
                
    }
    
   
    public void deleteUsuario(Usuario Usu) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(Usu);
        t.commit();
          s.close();
    }

  
    public Usuario readUsuario(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Usuario where nombre_usuario ='" + id + "'");
        Usuario Usu = (Usuario) q.uniqueResult();
        t.commit();
        s.close();
        return Usu;
    }
}
