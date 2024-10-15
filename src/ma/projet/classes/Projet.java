
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "projets")
public class Projet {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id ;
 private String nom ;
 @Temporal(TemporalType.DATE)
 @Column(name = "date_Debut")
 private Date dD ;
 @Temporal(TemporalType.DATE)
 @Column(name = "date_Fin")
 private Date dF ;
 
 @ManyToOne
 @JoinColumn(name = "chefDeProjet")
 private Employe chefProjet ;
 
 @OneToMany(mappedBy = "projet",fetch = FetchType.EAGER)
 private List<Tache> taches ;

    public Projet() {
    }

    public Projet(String nom, Date dD, Date dF) {
        this.nom = nom;
        this.dD = dD;
        this.dF = dF;
    }

    public Projet(String nom, Date dD, Date dF, Employe chefProjet) {
        this.nom = nom;
        this.dD = dD;
        this.dF = dF;
        this.chefProjet = chefProjet;
    }

    public Projet(String nom, Date dD, Date dF, Employe chefProjet, List<Tache> taches) {
        this.nom = nom;
        this.dD = dD;
        this.dF = dF;
        this.chefProjet = chefProjet;
        this.taches = taches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getdD() {
        return dD;
    }

    public void setdD(Date dD) {
        this.dD = dD;
    }

    public Date getdF() {
        return dF;
    }

    public void setdF(Date dF) {
        this.dF = dF;
    }

    public Employe getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(Employe chefProjet) {
        this.chefProjet = chefProjet;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", nom=" + nom + ", dD=" + dD + ", dF=" + dF + '}';
    }

}
