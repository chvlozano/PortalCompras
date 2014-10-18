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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p WHERE p.codCia =:codCia"),
    @NamedQuery(name = "Proveedor.findByCodProveedor", query = "SELECT p FROM Proveedor p WHERE p.codProveedor = :codProveedor"),
    @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedor.findByDescripcionProveedor", query = "SELECT p FROM Proveedor p WHERE p.descripcionProveedor = :descripcionProveedor"),
    @NamedQuery(name = "Proveedor.findByCuentaContableProveedor", query = "SELECT p FROM Proveedor p WHERE p.cuentaContableProveedor = :cuentaContableProveedor")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PROVEEDOR")
    private Integer codProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_PROVEEDOR")
    private String descripcionProveedor;
    @Size(max = 15)
    @Column(name = "CUENTA_CONTABLE_PROVEEDOR")
    private String cuentaContableProveedor;
    @OneToMany(mappedBy = "codProveedor")
    private List<Cotizacion> cotizacionList;
    @OneToMany(mappedBy = "codProveedor")
    private List<ActaAceptacion> actaAceptacionList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;

    public Proveedor() {
    }

    public Proveedor(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Proveedor(Integer codProveedor, String nombreProveedor) {
        this.codProveedor = codProveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDescripcionProveedor() {
        return descripcionProveedor;
    }

    public void setDescripcionProveedor(String descripcionProveedor) {
        this.descripcionProveedor = descripcionProveedor;
    }

    public String getCuentaContableProveedor() {
        return cuentaContableProveedor;
    }

    public void setCuentaContableProveedor(String cuentaContableProveedor) {
        this.cuentaContableProveedor = cuentaContableProveedor;
    }

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @XmlTransient
    public List<ActaAceptacion> getActaAceptacionList() {
        return actaAceptacionList;
    }

    public void setActaAceptacionList(List<ActaAceptacion> actaAceptacionList) {
        this.actaAceptacionList = actaAceptacionList;
    }

    public Cia getCodCia() {
        return codCia;
    }

    public void setCodCia(Cia codCia) {
        this.codCia = codCia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProveedor != null ? codProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codProveedor == null && other.codProveedor != null) || (this.codProveedor != null && !this.codProveedor.equals(other.codProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Proveedor[ codProveedor=" + codProveedor + " ]";
    }
    
}
