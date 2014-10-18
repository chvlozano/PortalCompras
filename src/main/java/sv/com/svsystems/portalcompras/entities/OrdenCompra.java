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
@Table(name = "orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o WHERE o.codCia =:codCia"),
    @NamedQuery(name = "OrdenCompra.findByPeriodo", query = "SELECT o FROM OrdenCompra o WHERE o.codCia = :codCia AND o.ordenCompraPK.periodo = :periodo"),
    @NamedQuery(name = "OrdenCompra.findByCodOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.ordenCompraPK.codOrdenCompra = :codOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaOrdenCompra = :fechaOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByEstadoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.estadoOrdenCompra = :estadoOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaRequeridaOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaRequeridaOrdenCompra = :fechaRequeridaOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaPagoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaPagoOrdenCompra = :fechaPagoOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByNombreChequeOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.nombreChequeOrdenCompra = :nombreChequeOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByNumCotizacionOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.numCotizacionOrdenCompra = :numCotizacionOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByObservacionOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.observacionOrdenCompra = :observacionOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByDescuentoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.descuentoOrdenCompra = :descuentoOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByTotalOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.totalOrdenCompra = :totalOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByIvaOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.ivaOrdenCompra = :ivaOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaDespachoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaDespachoOrdenCompra = :fechaDespachoOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByAutorizadaOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.autorizadaOrdenCompra = :autorizadaOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findBySaldoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.saldoOrdenCompra = :saldoOrdenCompra")})
public class OrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenCompraPK ordenCompraPK;
    @Column(name = "FECHA_ORDEN_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaOrdenCompra;
    @Size(max = 1)
    @Column(name = "ESTADO_ORDEN_COMPRA")
    private String estadoOrdenCompra;
    @Column(name = "FECHA_REQUERIDA_ORDEN_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaRequeridaOrdenCompra;
    @Column(name = "FECHA_PAGO_ORDEN_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaPagoOrdenCompra;
    @Size(max = 200)
    @Column(name = "NOMBRE_CHEQUE_ORDEN_COMPRA")
    private String nombreChequeOrdenCompra;
    @Column(name = "NUM_COTIZACION_ORDEN_COMPRA")
    private Integer numCotizacionOrdenCompra;
    @Size(max = 2000)
    @Column(name = "OBSERVACION_ORDEN_COMPRA")
    private String observacionOrdenCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCUENTO_ORDEN_COMPRA")
    private BigDecimal descuentoOrdenCompra;
    @Column(name = "TOTAL_ORDEN_COMPRA")
    private BigDecimal totalOrdenCompra;
    @Column(name = "IVA_ORDEN_COMPRA")
    private BigDecimal ivaOrdenCompra;
    @Column(name = "FECHA_DESPACHO_ORDEN_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaDespachoOrdenCompra;
    @Column(name = "AUTORIZADA_ORDEN_COMPRA")
    private Short autorizadaOrdenCompra;
    @Column(name = "SALDO_ORDEN_COMPRA")
    private BigDecimal saldoOrdenCompra;
    @OneToMany(mappedBy = "ordenCompra")
    private List<DetOrdenCompra> detOrdenCompraList;
    @JoinColumn(name = "COD_TIPO_PAGO", referencedColumnName = "COD_TIPO_PAGO")
    @ManyToOne
    private TipoPago codTipoPago;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;
    @OneToMany(mappedBy = "ordenCompra")
    private List<ActaAceptacion> actaAceptacionList;
    @OneToMany(mappedBy = "ordenCompra")
    private List<ArchivoEspcTecnica> archivoEspcTecnicaList;

    public OrdenCompra() {
    }

    public OrdenCompra(OrdenCompraPK ordenCompraPK) {
        this.ordenCompraPK = ordenCompraPK;
    }

    public OrdenCompra(String periodo, int codOrdenCompra) {
        this.ordenCompraPK = new OrdenCompraPK(periodo, codOrdenCompra);
    }

    public OrdenCompraPK getOrdenCompraPK() {
        return ordenCompraPK;
    }

    public void setOrdenCompraPK(OrdenCompraPK ordenCompraPK) {
        this.ordenCompraPK = ordenCompraPK;
    }

    public Date getFechaOrdenCompra() {
        return fechaOrdenCompra;
    }

    public void setFechaOrdenCompra(Date fechaOrdenCompra) {
        this.fechaOrdenCompra = fechaOrdenCompra;
    }

    public String getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(String estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    public Date getFechaRequeridaOrdenCompra() {
        return fechaRequeridaOrdenCompra;
    }

    public void setFechaRequeridaOrdenCompra(Date fechaRequeridaOrdenCompra) {
        this.fechaRequeridaOrdenCompra = fechaRequeridaOrdenCompra;
    }

    public Date getFechaPagoOrdenCompra() {
        return fechaPagoOrdenCompra;
    }

    public void setFechaPagoOrdenCompra(Date fechaPagoOrdenCompra) {
        this.fechaPagoOrdenCompra = fechaPagoOrdenCompra;
    }

    public String getNombreChequeOrdenCompra() {
        return nombreChequeOrdenCompra;
    }

    public void setNombreChequeOrdenCompra(String nombreChequeOrdenCompra) {
        this.nombreChequeOrdenCompra = nombreChequeOrdenCompra;
    }

    public Integer getNumCotizacionOrdenCompra() {
        return numCotizacionOrdenCompra;
    }

    public void setNumCotizacionOrdenCompra(Integer numCotizacionOrdenCompra) {
        this.numCotizacionOrdenCompra = numCotizacionOrdenCompra;
    }

    public String getObservacionOrdenCompra() {
        return observacionOrdenCompra;
    }

    public void setObservacionOrdenCompra(String observacionOrdenCompra) {
        this.observacionOrdenCompra = observacionOrdenCompra;
    }

    public BigDecimal getDescuentoOrdenCompra() {
        return descuentoOrdenCompra;
    }

    public void setDescuentoOrdenCompra(BigDecimal descuentoOrdenCompra) {
        this.descuentoOrdenCompra = descuentoOrdenCompra;
    }

    public BigDecimal getTotalOrdenCompra() {
        return totalOrdenCompra;
    }

    public void setTotalOrdenCompra(BigDecimal totalOrdenCompra) {
        this.totalOrdenCompra = totalOrdenCompra;
    }

    public BigDecimal getIvaOrdenCompra() {
        return ivaOrdenCompra;
    }

    public void setIvaOrdenCompra(BigDecimal ivaOrdenCompra) {
        this.ivaOrdenCompra = ivaOrdenCompra;
    }

    public Date getFechaDespachoOrdenCompra() {
        return fechaDespachoOrdenCompra;
    }

    public void setFechaDespachoOrdenCompra(Date fechaDespachoOrdenCompra) {
        this.fechaDespachoOrdenCompra = fechaDespachoOrdenCompra;
    }

    public Short getAutorizadaOrdenCompra() {
        return autorizadaOrdenCompra;
    }

    public void setAutorizadaOrdenCompra(Short autorizadaOrdenCompra) {
        this.autorizadaOrdenCompra = autorizadaOrdenCompra;
    }

    public BigDecimal getSaldoOrdenCompra() {
        return saldoOrdenCompra;
    }

    public void setSaldoOrdenCompra(BigDecimal saldoOrdenCompra) {
        this.saldoOrdenCompra = saldoOrdenCompra;
    }

    @XmlTransient
    public List<DetOrdenCompra> getDetOrdenCompraList() {
        return detOrdenCompraList;
    }

    public void setDetOrdenCompraList(List<DetOrdenCompra> detOrdenCompraList) {
        this.detOrdenCompraList = detOrdenCompraList;
    }

    public TipoPago getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(TipoPago codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    public Cia getCodCia() {
        return codCia;
    }

    public void setCodCia(Cia codCia) {
        this.codCia = codCia;
    }

    @XmlTransient
    public List<ActaAceptacion> getActaAceptacionList() {
        return actaAceptacionList;
    }

    public void setActaAceptacionList(List<ActaAceptacion> actaAceptacionList) {
        this.actaAceptacionList = actaAceptacionList;
    }

    @XmlTransient
    public List<ArchivoEspcTecnica> getArchivoEspcTecnicaList() {
        return archivoEspcTecnicaList;
    }

    public void setArchivoEspcTecnicaList(List<ArchivoEspcTecnica> archivoEspcTecnicaList) {
        this.archivoEspcTecnicaList = archivoEspcTecnicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenCompraPK != null ? ordenCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.ordenCompraPK == null && other.ordenCompraPK != null) || (this.ordenCompraPK != null && !this.ordenCompraPK.equals(other.ordenCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.OrdenCompra[ ordenCompraPK=" + ordenCompraPK + " ]";
    }
    
}
