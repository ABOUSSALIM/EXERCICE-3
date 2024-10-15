/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


/**
 *
 * @author AdMin
 */
public class ProjetService implements IDao <Projet> {

    @Override
    public boolean create(Projet o) {
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
    public Projet getById(int id) {
        Session session = null;
        Projet e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Projet) session.get(Projet.class, id);
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
    public List<Projet> getAll() {
        Session session = null;
        List<Projet>  projets = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            session.getTransaction().commit();
            return projets;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return projets;
    }

    
     public void listeTache(Projet p){
         System.out.println("Les taches du "+p);
         System.out.println("Sont : "+p.getTaches());
     }
}
