
package ma.projet.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePk;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;


public class Test {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Scanner scan = new Scanner(System.in);
        Date d1 = null ;
        Date d2 = null ;
         
        EmployeService mps = new EmployeService();
        ProjetService pjs = new ProjetService();
        TacheService ths = new TacheService();
        EmployeTacheService mpts = new EmployeTacheService();
        
       
         mps.create(new Employe("ABOSSALIM","OUSSAMA","0703789220"));
         mps.create(new Employe("ABDESSAMAD","EZZELZOULI","0711111110"));
         mps.create(new Employe("HAFIDI","ADAM","0722222220"));
         
         pjs.create(new Projet("Code 212", new Date(), new Date(), mps.getById(1)));
         pjs.create(new Projet("Code 33", new Date(), new Date(), mps.getById(1)));
         pjs.create(new Projet("Code 200", new Date(), new Date(), mps.getById(1)));
         pjs.create(new Projet("Code 30", new Date(), new Date(), mps.getById(1)));
         pjs.create(new Projet("Code 30", new Date(), new Date(), mps.getById(1)));
         pjs.create(new Projet("Code 30", new Date(), new Date(), mps.getById(1)));
         
         ths.create(new Tache("Controle", new Date(),new Date(), 10000.0,pjs.getById(1)));
         ths.create(new Tache("TAFEM", new Date(),new Date(), 20000.0,pjs.getById(1)));
         ths.create(new Tache("FATAL", new Date(),new Date(), 40000.0,pjs.getById(1)));
         ths.create(new Tache("DRIVE", new Date(),new Date(), 70000.0,pjs.getById(3)));
         ths.create(new Tache("DRIVE", new Date(),new Date(), 70000.0,pjs.getById(5)));
         //liste des projet par chef de projet 
         mps.listeProjet(mps.getById(1));
         // liste des taches d'un projet
         pjs.listeTache(pjs.getById(1));
         //Affichage
         mpts.create(new EmployeTache(new EmployeTachePk(3,1),mps.getById(3), ths.getById(1),new Date(), new Date()));
         mpts.create(new EmployeTache(new EmployeTachePk(3,2),mps.getById(3), ths.getById(2),new Date(), new Date()));
         mpts.create(new EmployeTache(new EmployeTachePk(3,4),mps.getById(3), ths.getById(4),new Date(), new Date()));
         mpts.create(new EmployeTache(new EmployeTachePk(3,5),mps.getById(3), ths.getById(5),new Date(), new Date()));
         mpts.create(new EmployeTache(new EmployeTachePk(2,3),mps.getById(2), ths.getById(3),new Date(), new Date()));
         
         mpts .TacheRealise(pjs.getById(1));
         
         //10ths.prisSupTache();
         try{
             System.out.println("Entrer la date de debut dd-mm-yyyy :");
             String s = scan.nextLine();
             d1 = sdf.parse(s);
             System.out.println("Entrer la date de debut dd-mm-yyyy :");
             s = scan.nextLine();
             d2 = sdf.parse(s);
         }catch(Exception e){
             System.out.println(" "+e.getMessage());
         }
         mpts.tacheRealise(d1,d2);
    }
   
}
