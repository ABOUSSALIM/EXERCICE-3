
package ma.projet.classes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmployeTache {
    @EmbeddedId
    private EmployeTachePk pk ;
    @ManyToOne
    @JoinColumn(name = "employe",insertable = false,updatable = false)
    private Employe employe ;
    @ManyToOne
    @JoinColumn(name = "tache",insertable = false,updatable = false)
    private Tache tache ;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_Debut_Reelle")
    private Date dDR ;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_Fin_Reelle")
    private Date dFR ;

    public EmployeTache() {
    }

    public EmployeTache(EmployeTachePk pk, Employe employe, Tache tache, Date dDR, Date dFR) {
        this.pk = pk;
        this.employe = employe;
        this.tache = tache;
        this.dDR = dDR;
        this.dFR = dFR;
    }

    public EmployeTachePk getPk() {
        return pk;
    }

    public void setPk(EmployeTachePk pk) {
        this.pk = pk;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Date getdDR() {
        return dDR;
    }

    public void setdDR(Date dDR) {
        this.dDR = dDR;
    }

    public Date getdFR() {
        return dFR;
    }

    public void setdFR(Date dFR) {
        this.dFR = dFR;
    }
    
    
}
