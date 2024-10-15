
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.service.ProjetService;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class EmployeTacheService implements IDao <EmployeTache> {

    @Override
    public boolean create(EmployeTache o) {
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
    public EmployeTache getById(int id) {
        Session session = null;
        EmployeTache e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (EmployeTache) session.get(EmployeTache.class, id);
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
    public List<EmployeTache> getAll() {
        Session session = null;
        List<EmployeTache>  employetaches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            employetaches = session.createQuery("from EmployeTache").list();
            session.getTransaction().commit();
            return employetaches;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employetaches;
    } 
    
    public void TacheRealise(Projet p){ 
        int id =p.getId();
        System.out.println("Projet : "+id+" Nom :"+p.getNom()
        +"Date Debut : "+p.getdD());
        System.out.println("Liste des taches : ");
        System.out.println("Num                    Nom                Date Début Réelle          Date Fin Réelle ");
        for (EmployeTache m : getAll()){
           if(m.getTache().getProjet().getId() == id ){
               System.out.println(m.getTache().getId()+"                    "+m.getTache().getNom()+"                "+m.getdDR()+"          "+m.getdFR());
           } 
        }
    
    }
    public void tacheRealise(Date d1,Date d2){
        for(EmployeTache empt : getAll()){
            Date d = empt.getdDR();
            if(d.compareTo(d1)>= 0 && empt.getdFR().compareTo(d2)<= 0){
                System.out.println(empt.getTache().toString());
        }
    }
}
}
        
    
    

