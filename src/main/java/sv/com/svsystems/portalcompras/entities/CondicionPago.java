/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "condicion_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionPago.findAll", query = "SELECT c FROM CondicionPago c"),
    @NamedQuery(name = "CondicionPago.findByTipoCondicionPago", query = "SELECT c FROM CondicionPago c WHERE c.tipoCondicionPago = :tipoCondicionPago"),
    @NamedQuery(name = "CondicionPago.findByDescripcionCondicion", query = "SELECT c FROM CondicionPago c WHERE c.descripcionCondicion = :descripcionCondicion")})
public class CondicionPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_CONDICION_PAGO")
    private String tipoCondicionPago;
    @Size(max = 150)
    @Column(name = "DESCRIPCION_CONDICION_")
    private String descripcionCondicion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "condicionPago")
    private DetCondicionPago detCondicionPago;
    @JoinColumn(name = "COD_TIPO_PAGO", referencedColumnName = "COD_TIPO_PAGO")
    @ManyToOne
    private TipoPago codTipoPago;

    public CondicionPago() {
    }

    public CondicionPago(String tipoCondicionPago) {
        this.tipoCondicionPago = tipoCondicionPago;
    }

    public String getTipoCondicionPago() {
        return tipoCondicionPago;
    }

    public void setTipoCondicionPago(String tipoCondicionPago) {
        this.tipoCondicionPago = tipoCondicionPago;
    }

    public String getDescripcionCondicion() {
        return descripcionCondicion;
    }

    public void setDescripcionCondicion(String descripcionCondicion) {
        this.descripcionCondicion = descripcionCondicion;
    }

    public DetCondicionPago getDetCondicionPago() {
        return detCondicionPago;
    }

    public void setDetCondicionPago(DetCondicionPago detCondicionPago) {
        this.detCondicionPago = detCondicionPago;
    }

    public TipoPago getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(TipoPago codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCondicionPago != null ? tipoCondicionPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionPago)) {
            return false;
        }
        CondicionPago other = (CondicionPago) object;
        if ((this.tipoCondicionPago == null && other.tipoCondicionPago != null) || (this.tipoCondicionPago != null && !this.tipoCondicionPago.equals(other.tipoCondicionPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.CondicionPago[ tipoCondicionPago=" + tipoCondicionPago + " ]";
    }
    
}
