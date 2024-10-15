
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeTachePk implements Serializable{
    private int employe ;
    private int tache ;

    public EmployeTachePk() {
    }

    public EmployeTachePk(int employe, int tache) {
        this.employe = employe;
        this.tache = tache;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getTache() {
        return tache;
    }

    public void setTache(int tache) {
        this.tache = tache;
    }
    
    
}
