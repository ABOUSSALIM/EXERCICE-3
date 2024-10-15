
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class TacheService implements IDao <Tache> {

    @Override
    public boolean create(Tache o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Tache getById(int id) {
        Session session = null;
        Tache e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Tache) session.get(Tache.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<Tache> getAll() {
        Session session = null;
        List<Tache>  taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            session.getTransaction().commit();
            return taches;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return taches;
    }
 
    
}
    
