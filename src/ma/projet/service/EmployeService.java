
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class EmployeService implements IDao <Employe> {

    @Override
    public boolean create(Employe o) {
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
    public Employe getById(int id) {
        Session session = null;
        Employe e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Employe) session.get(Employe.class, id);
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
    public List<Employe> getAll() {
        Session session = null;
        List<Employe>  employes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            employes = session.createQuery("from Employe").list();
            session.getTransaction().commit();
            return employes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employes;
    }
 
    public  void listeTache(Employe e){
        
}
    public void listeProjet(Employe e){
        System.out.println("Les projet  gérées par cet epmloye est : ");
        System.out.println(e.getProjets()+"\n");
        
        
    }
}
