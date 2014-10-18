/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "depto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depto.findAll", query = "SELECT d FROM Depto d"),
    @NamedQuery(name = "Depto.findByCodDepto", query = "SELECT d FROM Depto d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "Depto.findByNomDepto", query = "SELECT d FROM Depto d WHERE d.nomDepto = :nomDepto")})
public class Depto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "NOM_DEPTO")
    private String nomDepto;
    @OneToMany(mappedBy = "codDepto")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;
    @OneToMany(mappedBy = "codDepto")
    private List<Emp> empList;

    public Depto() {
    }

    public Depto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Depto(Short codDepto, String nomDepto) {
        this.codDepto = codDepto;
        this.nomDepto = nomDepto;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getNomDepto() {
        return nomDepto;
    }

    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Cia getCodCia() {
        return codCia;
    }

    public void setCodCia(Cia codCia) {
        this.codCia = codCia;
    }

    @XmlTransient
    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepto != null ? codDepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depto)) {
            return false;
        }
        Depto other = (Depto) object;
        if ((this.codDepto == null && other.codDepto != null) || (this.codDepto != null && !this.codDepto.equals(other.codDepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Depto[ codDepto=" + codDepto + " ]";
    }
    
}
