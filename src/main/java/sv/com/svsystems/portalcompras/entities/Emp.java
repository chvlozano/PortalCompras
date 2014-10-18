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
@Table(name = "emp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e"),
    @NamedQuery(name = "Emp.findByCodEmp", query = "SELECT e FROM Emp e WHERE e.codEmp = :codEmp"),
    @NamedQuery(name = "Emp.findByNombresEmp", query = "SELECT e FROM Emp e WHERE e.nombresEmp = :nombresEmp"),
    @NamedQuery(name = "Emp.findByApellidosEmp", query = "SELECT e FROM Emp e WHERE e.apellidosEmp = :apellidosEmp"),
    @NamedQuery(name = "Emp.findByDuiEmp", query = "SELECT e FROM Emp e WHERE e.duiEmp = :duiEmp"),
    @NamedQuery(name = "Emp.findByTelefonoEmp", query = "SELECT e FROM Emp e WHERE e.telefonoEmp = :telefonoEmp"),
    @NamedQuery(name = "Emp.findByCelularEmp", query = "SELECT e FROM Emp e WHERE e.celularEmp = :celularEmp"),
    @NamedQuery(name = "Emp.findByUsuarioEmp", query = "SELECT e FROM Emp e WHERE e.usuarioEmp = :usuarioEmp")})
public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "NOMBRES_EMP")
    private String nombresEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "APELLIDOS_EMP")
    private String apellidosEmp;
    @Size(max = 20)
    @Column(name = "DUI_EMP")
    private String duiEmp;
    @Size(max = 10)
    @Column(name = "TELEFONO_EMP")
    private String telefonoEmp;
    @Size(max = 10)
    @Column(name = "CELULAR_EMP")
    private String celularEmp;
    @Size(max = 20)
    @Column(name = "USUARIO_EMP")
    private String usuarioEmp;
    @OneToMany(mappedBy = "codEmp")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")
    @ManyToOne
    private Depto codDepto;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Emp() {
    }

    public Emp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public Emp(Integer codEmp, String nombresEmp, String apellidosEmp) {
        this.codEmp = codEmp;
        this.nombresEmp = nombresEmp;
        this.apellidosEmp = apellidosEmp;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public String getNombresEmp() {
        return nombresEmp;
    }

    public void setNombresEmp(String nombresEmp) {
        this.nombresEmp = nombresEmp;
    }

    public String getApellidosEmp() {
        return apellidosEmp;
    }

    public void setApellidosEmp(String apellidosEmp) {
        this.apellidosEmp = apellidosEmp;
    }

    public String getDuiEmp() {
        return duiEmp;
    }

    public void setDuiEmp(String duiEmp) {
        this.duiEmp = duiEmp;
    }

    public String getTelefonoEmp() {
        return telefonoEmp;
    }

    public void setTelefonoEmp(String telefonoEmp) {
        this.telefonoEmp = telefonoEmp;
    }

    public String getCelularEmp() {
        return celularEmp;
    }

    public void setCelularEmp(String celularEmp) {
        this.celularEmp = celularEmp;
    }

    public String getUsuarioEmp() {
        return usuarioEmp;
    }

    public void setUsuarioEmp(String usuarioEmp) {
        this.usuarioEmp = usuarioEmp;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Depto getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Depto codDepto) {
        this.codDepto = codDepto;
    }

    public Cia getCodCia() {
        return codCia;
    }

    public void setCodCia(Cia codCia) {
        this.codCia = codCia;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmp != null ? codEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.codEmp == null && other.codEmp != null) || (this.codEmp != null && !this.codEmp.equals(other.codEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Emp[ codEmp=" + codEmp + " ]";
    }
    
}
