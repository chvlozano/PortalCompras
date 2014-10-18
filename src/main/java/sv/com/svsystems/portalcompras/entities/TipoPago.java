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
@Table(name = "tipo_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t"),
    @NamedQuery(name = "TipoPago.findByCodTipoPago", query = "SELECT t FROM TipoPago t WHERE t.codTipoPago = :codTipoPago"),
    @NamedQuery(name = "TipoPago.findByNombreTipoPago", query = "SELECT t FROM TipoPago t WHERE t.nombreTipoPago = :nombreTipoPago"),
    @NamedQuery(name = "TipoPago.findByDescripcionTipoPago", query = "SELECT t FROM TipoPago t WHERE t.descripcionTipoPago = :descripcionTipoPago")})
public class TipoPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_PAGO")
    private Integer codTipoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NOMBRE_TIPO_PAGO")
    private String nombreTipoPago;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_TIPO_PAGO")
    private String descripcionTipoPago;
    @OneToMany(mappedBy = "codTipoPago")
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(mappedBy = "codTipoPago")
    private List<CondicionPago> condicionPagoList;

    public TipoPago() {
    }

    public TipoPago(Integer codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    public TipoPago(Integer codTipoPago, String nombreTipoPago) {
        this.codTipoPago = codTipoPago;
        this.nombreTipoPago = nombreTipoPago;
    }

    public Integer getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(Integer codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    public String getNombreTipoPago() {
        return nombreTipoPago;
    }

    public void setNombreTipoPago(String nombreTipoPago) {
        this.nombreTipoPago = nombreTipoPago;
    }

    public String getDescripcionTipoPago() {
        return descripcionTipoPago;
    }

    public void setDescripcionTipoPago(String descripcionTipoPago) {
        this.descripcionTipoPago = descripcionTipoPago;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @XmlTransient
    public List<CondicionPago> getCondicionPagoList() {
        return condicionPagoList;
    }

    public void setCondicionPagoList(List<CondicionPago> condicionPagoList) {
        this.condicionPagoList = condicionPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoPago != null ? codTipoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPago)) {
            return false;
        }
        TipoPago other = (TipoPago) object;
        if ((this.codTipoPago == null && other.codTipoPago != null) || (this.codTipoPago != null && !this.codTipoPago.equals(other.codTipoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.TipoPago[ codTipoPago=" + codTipoPago + " ]";
    }
    
}
