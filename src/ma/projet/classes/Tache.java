package ma.projet.classes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "taches")
@NamedQuery(name = "prixSup",query ="SELECT t FROM Tache t WHERE t.prix > :prix")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id ;
    private String nom ;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Debut")
    private Date dD ;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Fin")
    private Date dF ;
    private Double prix ;
    @ManyToOne
    @JoinColumn(name ="projet")
    private Projet projet ;

    public Tache() {
    }

    public Tache(String nom, Date dD, Date dF, Double prix) {
        this.nom = nom;
        this.dD = dD;
        this.dF = dF;
        this.prix = prix;
    }

    public Tache(String nom, Date dD, Date dF, Double prix, Projet projet) {
        this.nom = nom;
        this.dD = dD;
        this.dF = dF;
        this.prix = prix;
        this.projet = projet;
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + id + ", nom=" + nom + ", dD=" + dD + ", dF=" + dF + ", prix=" + prix + '}';
    }

    
}
