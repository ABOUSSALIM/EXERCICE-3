
package ma.projet.classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employes")
public class Employe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id ;
  private String nom ;
  private String prenom ;
  @Column(name = "telephone")
  private String tele ;
  
  
  @OneToMany(mappedBy = "chefProjet",fetch = FetchType.EAGER)
  private List<Projet> projets ;

    public Employe() {
    }

    public Employe(String nom, String prenom, String tele) {
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
    }

    public Employe(String nom, String prenom, String tele, List<Projet> projets) {
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.projets = projets;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

   
    
}
