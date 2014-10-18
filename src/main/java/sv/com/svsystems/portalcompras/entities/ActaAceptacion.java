/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "acta_aceptacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActaAceptacion.findAll", query = "SELECT a FROM ActaAceptacion a"),
    @NamedQuery(name = "ActaAceptacion.findByPeriodoActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.actaAceptacionPK.periodoActaAceptacion = :periodoActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByCodActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.actaAceptacionPK.codActaAceptacion = :codActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByFechaActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.fechaActaAceptacion = :fechaActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByEstadoActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.estadoActaAceptacion = :estadoActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByFechaCambioActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.fechaCambioActaAceptacion = :fechaCambioActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findBySubTotalActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.subTotalActaAceptacion = :subTotalActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByDescGlobalActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.descGlobalActaAceptacion = :descGlobalActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByIvaActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.ivaActaAceptacion = :ivaActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByTotalActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.totalActaAceptacion = :totalActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByNumFacturaActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.numFacturaActaAceptacion = :numFacturaActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByResultadoActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.resultadoActaAceptacion = :resultadoActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByObservacionActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.observacionActaAceptacion = :observacionActaAceptacion"),
    @NamedQuery(name = "ActaAceptacion.findByUsuarioActaAceptacion", query = "SELECT a FROM ActaAceptacion a WHERE a.usuarioActaAceptacion = :usuarioActaAceptacion")})
public class ActaAceptacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActaAceptacionPK actaAceptacionPK;
    @Column(name = "FECHA_ACTA_ACEPTACION")
    @Temporal(TemporalType.DATE)
    private Date fechaActaAceptacion;
    @Size(max = 1)
    @Column(name = "ESTADO_ACTA_ACEPTACION")
    private String estadoActaAceptacion;
    @Column(name = "FECHA_CAMBIO_ACTA_ACEPTACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCambioActaAceptacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SUB_TOTAL_ACTA_ACEPTACION")
    private BigDecimal subTotalActaAceptacion;
    @Column(name = "DESC_GLOBAL_ACTA_ACEPTACION")
    private BigDecimal descGlobalActaAceptacion;
    @Column(name = "IVA_ACTA_ACEPTACION")
    private BigDecimal ivaActaAceptacion;
    @Column(name = "TOTAL_ACTA_ACEPTACION")
    private BigDecimal totalActaAceptacion;
    @Size(max = 15)
    @Column(name = "NUM_FACTURA_ACTA_ACEPTACION")
    private String numFacturaActaAceptacion;
    @Size(max = 200)
    @Column(name = "RESULTADO_ACTA_ACEPTACION")
    private String resultadoActaAceptacion;
    @Size(max = 2000)
    @Column(name = "OBSERVACION_ACTA_ACEPTACION")
    private String observacionActaAceptacion;
    @Size(max = 20)
    @Column(name = "USUARIO_ACTA_ACEPTACION")
    private String usuarioActaAceptacion;
    @JoinColumns({
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO"),
        @JoinColumn(name = "COD_ORDEN_COMPRA", referencedColumnName = "COD_ORDEN_COMPRA")})
    @ManyToOne
    private OrdenCompra ordenCompra;
    @JoinColumn(name = "COD_PROVEEDOR", referencedColumnName = "COD_PROVEEDOR")
    @ManyToOne
    private Proveedor codProveedor;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;

    public ActaAceptacion() {
    }

    public ActaAceptacion(ActaAceptacionPK actaAceptacionPK) {
        this.actaAceptacionPK = actaAceptacionPK;
    }

    public ActaAceptacion(String periodoActaAceptacion, int codActaAceptacion) {
        this.actaAceptacionPK = new ActaAceptacionPK(periodoActaAceptacion, codActaAceptacion);
    }

    public ActaAceptacionPK getActaAceptacionPK() {
        return actaAceptacionPK;
    }

    public void setActaAceptacionPK(ActaAceptacionPK actaAceptacionPK) {
        this.actaAceptacionPK = actaAceptacionPK;
    }

    public Date getFechaActaAceptacion() {
        return fechaActaAceptacion;
    }

    public void setFechaActaAceptacion(Date fechaActaAceptacion) {
        this.fechaActaAceptacion = fechaActaAceptacion;
    }

    public String getEstadoActaAceptacion() {
        return estadoActaAceptacion;
    }

    public void setEstadoActaAceptacion(String estadoActaAceptacion) {
        this.estadoActaAceptacion = estadoActaAceptacion;
    }

    public Date getFechaCambioActaAceptacion() {
        return fechaCambioActaAceptacion;
    }

    public void setFechaCambioActaAceptacion(Date fechaCambioActaAceptacion) {
        this.fechaCambioActaAceptacion = fechaCambioActaAceptacion;
    }

    public BigDecimal getSubTotalActaAceptacion() {
        return subTotalActaAceptacion;
    }

    public void setSubTotalActaAceptacion(BigDecimal subTotalActaAceptacion) {
        this.subTotalActaAceptacion = subTotalActaAceptacion;
    }

    public BigDecimal getDescGlobalActaAceptacion() {
        return descGlobalActaAceptacion;
    }

    public void setDescGlobalActaAceptacion(BigDecimal descGlobalActaAceptacion) {
        this.descGlobalActaAceptacion = descGlobalActaAceptacion;
    }

    public BigDecimal getIvaActaAceptacion() {
        return ivaActaAceptacion;
    }

    public void setIvaActaAceptacion(BigDecimal ivaActaAceptacion) {
        this.ivaActaAceptacion = ivaActaAceptacion;
    }

    public BigDecimal getTotalActaAceptacion() {
        return totalActaAceptacion;
    }

    public void setTotalActaAceptacion(BigDecimal totalActaAceptacion) {
        this.totalActaAceptacion = totalActaAceptacion;
    }

    public String getNumFacturaActaAceptacion() {
        return numFacturaActaAceptacion;
    }

    public void setNumFacturaActaAceptacion(String numFacturaActaAceptacion) {
        this.numFacturaActaAceptacion = numFacturaActaAceptacion;
    }

    public String getResultadoActaAceptacion() {
        return resultadoActaAceptacion;
    }

    public void setResultadoActaAceptacion(String resultadoActaAceptacion) {
        this.resultadoActaAceptacion = resultadoActaAceptacion;
    }

    public String getObservacionActaAceptacion() {
        return observacionActaAceptacion;
    }

    public void setObservacionActaAceptacion(String observacionActaAceptacion) {
        this.observacionActaAceptacion = observacionActaAceptacion;
    }

    public String getUsuarioActaAceptacion() {
        return usuarioActaAceptacion;
    }

    public void setUsuarioActaAceptacion(String usuarioActaAceptacion) {
        this.usuarioActaAceptacion = usuarioActaAceptacion;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actaAceptacionPK != null ? actaAceptacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActaAceptacion)) {
            return false;
        }
        ActaAceptacion other = (ActaAceptacion) object;
        if ((this.actaAceptacionPK == null && other.actaAceptacionPK != null) || (this.actaAceptacionPK != null && !this.actaAceptacionPK.equals(other.actaAceptacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.ActaAceptacion[ actaAceptacionPK=" + actaAceptacionPK + " ]";
    }
    
}
