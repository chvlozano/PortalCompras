/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c "),
    @NamedQuery(name = "Cotizacion.findByCia", query = "SELECT c FROM Cotizacion c WHERE c.codCia =:codCia"),
    @NamedQuery(name = "Cotizacion.findByPK", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionPK =:cotizacionPK"),
    @NamedQuery(name = "Cotizacion.findByCodCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.codCia =:codCia AND  c.cotizacionPK.codCotizacion = :codCotizacion"),
    @NamedQuery(name = "Cotizacion.findByPeriodoCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.codCia =:codCia AND c.cotizacionPK.periodoCotizacion =:periodoCotizacion"),
    @NamedQuery(name = "Cotizacion.findByFechaCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.fechaCotizacion = :fechaCotizacion"),
    @NamedQuery(name = "Cotizacion.findByEstadoCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.estadoCotizacion = :estadoCotizacion"),
    @NamedQuery(name = "Cotizacion.findByFechaRequeridaCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.fechaRequeridaCotizacion = :fechaRequeridaCotizacion"),
    @NamedQuery(name = "Cotizacion.findByObservacionCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.observacionCotizacion = :observacionCotizacion"),
    @NamedQuery(name = "Cotizacion.findByIvaCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.ivaCotizacion = :ivaCotizacion"),
    @NamedQuery(name = "Cotizacion.findByDescuentoCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.descuentoCotizacion = :descuentoCotizacion"),
    @NamedQuery(name = "Cotizacion.findByTotalCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.totalCotizacion = :totalCotizacion")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CotizacionPK cotizacionPK;
    @Column(name = "FECHA_COTIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCotizacion;
    @Column(name = "ESTADO_COTIZACION")
    private Short estadoCotizacion;
    @Column(name = "FECHA_REQUERIDA_COTIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaRequeridaCotizacion;
    @Size(max = 2000)
    @Column(name = "OBSERVACION_COTIZACION")
    private String observacionCotizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IVA_COTIZACION")
    private BigDecimal ivaCotizacion;
    @Column(name = "DESCUENTO_COTIZACION")
    private BigDecimal descuentoCotizacion;
    @Column(name = "TOTAL_COTIZACION")
    private BigDecimal totalCotizacion;
    @JoinColumn(name = "COD_PROVEEDOR", referencedColumnName = "COD_PROVEEDOR")
    @ManyToOne
    private Proveedor codProveedor;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;
    @OneToMany(mappedBy = "cotizacion")
    private List<DetCotizacion> detCotizacionList;

    public Cotizacion() {
    }

    public Cotizacion(CotizacionPK cotizacionPK) {
        this.cotizacionPK = cotizacionPK;
    }

    public Cotizacion(int codCotizacion, String periodoCotizacion) {
        this.cotizacionPK = new CotizacionPK(codCotizacion, periodoCotizacion);
    }

    public CotizacionPK getCotizacionPK() {
        return cotizacionPK;
    }

    public void setCotizacionPK(CotizacionPK cotizacionPK) {
        this.cotizacionPK = cotizacionPK;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public Short getEstadoCotizacion() {
        return estadoCotizacion;
    }

    public void setEstadoCotizacion(Short estadoCotizacion) {
        this.estadoCotizacion = estadoCotizacion;
    }

    public Date getFechaRequeridaCotizacion() {
        return fechaRequeridaCotizacion;
    }

    public void setFechaRequeridaCotizacion(Date fechaRequeridaCotizacion) {
        this.fechaRequeridaCotizacion = fechaRequeridaCotizacion;
    }

    public String getObservacionCotizacion() {
        return observacionCotizacion;
    }

    public void setObservacionCotizacion(String observacionCotizacion) {
        this.observacionCotizacion = observacionCotizacion;
    }

    public BigDecimal getIvaCotizacion() {
        return ivaCotizacion;
    }

    public void setIvaCotizacion(BigDecimal ivaCotizacion) {
        this.ivaCotizacion = ivaCotizacion;
    }

    public BigDecimal getDescuentoCotizacion() {
        return descuentoCotizacion;
    }

    public void setDescuentoCotizacion(BigDecimal descuentoCotizacion) {
        this.descuentoCotizacion = descuentoCotizacion;
    }

    public BigDecimal getTotalCotizacion() {
        return totalCotizacion;
    }

    public void setTotalCotizacion(BigDecimal totalCotizacion) {
        this.totalCotizacion = totalCotizacion;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Cia getCodCia() {
        return codCia;
    }

    public void setCodCia(Cia codCia) {
        this.codCia = codCia;
    }

    @XmlTransient
    public List<DetCotizacion> getDetCotizacionList() {
        return detCotizacionList;
    }

    public void setDetCotizacionList(List<DetCotizacion> detCotizacionList) {
        this.detCotizacionList = detCotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotizacionPK != null ? cotizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.cotizacionPK == null && other.cotizacionPK != null) || (this.cotizacionPK != null && !this.cotizacionPK.equals(other.cotizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Cotizacion[ cotizacionPK=" + cotizacionPK + " ]";
    }
    
}
