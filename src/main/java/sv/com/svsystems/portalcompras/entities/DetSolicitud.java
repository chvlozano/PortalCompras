/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "det_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetSolicitud.findAll", query = "SELECT d FROM DetSolicitud d"),
    @NamedQuery(name = "DetSolicitud.findBySolicitud", query = "SELECT d FROM DetSolicitud d WHERE d.solicitud =:solicitud"),
    @NamedQuery(name = "DetSolicitud.findByCodDetSolicitud", query = "SELECT d FROM DetSolicitud d WHERE d.codDetSolicitud = :codDetSolicitud"),
    @NamedQuery(name = "DetSolicitud.findByDescripcionDetSolicitud", query = "SELECT d FROM DetSolicitud d WHERE d.descripcionDetSolicitud = :descripcionDetSolicitud"),
    @NamedQuery(name = "DetSolicitud.findByCantidadDetSolicitud", query = "SELECT d FROM DetSolicitud d WHERE d.cantidadDetSolicitud = :cantidadDetSolicitud"),
    @NamedQuery(name = "DetSolicitud.findByCantidadAprobadaDetSolicitud", query = "SELECT d FROM DetSolicitud d WHERE d.cantidadAprobadaDetSolicitud = :cantidadAprobadaDetSolicitud"),
    @NamedQuery(name = "DetSolicitud.findByExistenciaDetSolicitud", query = "SELECT d FROM DetSolicitud d WHERE d.existenciaDetSolicitud = :existenciaDetSolicitud")})
public class DetSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DET_SOLICITUD")
    private Integer codDetSolicitud;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_DET_SOLICITUD")
    private String descripcionDetSolicitud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD_DET_SOLICITUD")
    private BigDecimal cantidadDetSolicitud;
    @Column(name = "CANTIDAD_APROBADA_DET_SOLICITUD")
    private BigDecimal cantidadAprobadaDetSolicitud;
    @Column(name = "EXISTENCIA_DET_SOLICITUD")
    private BigDecimal existenciaDetSolicitud;
    @JoinColumns({
        @JoinColumn(name = "COD_SOLICITUD", referencedColumnName = "COD_SOLICITUD"),
        @JoinColumn(name = "PERIODO_SOLICITUD", referencedColumnName = "PERIODO_SOLICITUD")})
    @ManyToOne
    private Solicitud solicitud;
    @JoinColumn(name = "COD_TIPO_PRODUCTO", referencedColumnName = "COD_TIPO_PRODUCTO")
    @ManyToOne
    private TipoProducto codTipoProducto;

    public DetSolicitud() {
    }

    public DetSolicitud(Integer codDetSolicitud) {
        this.codDetSolicitud = codDetSolicitud;
    }

    public Integer getCodDetSolicitud() {
        return codDetSolicitud;
    }

    public void setCodDetSolicitud(Integer codDetSolicitud) {
        this.codDetSolicitud = codDetSolicitud;
    }

    public String getDescripcionDetSolicitud() {
        return descripcionDetSolicitud;
    }

    public void setDescripcionDetSolicitud(String descripcionDetSolicitud) {
        this.descripcionDetSolicitud = descripcionDetSolicitud;
    }

    public BigDecimal getCantidadDetSolicitud() {
        return cantidadDetSolicitud;
    }

    public void setCantidadDetSolicitud(BigDecimal cantidadDetSolicitud) {
        this.cantidadDetSolicitud = cantidadDetSolicitud;
    }

    public BigDecimal getCantidadAprobadaDetSolicitud() {
        return cantidadAprobadaDetSolicitud;
    }

    public void setCantidadAprobadaDetSolicitud(BigDecimal cantidadAprobadaDetSolicitud) {
        this.cantidadAprobadaDetSolicitud = cantidadAprobadaDetSolicitud;
    }

    public BigDecimal getExistenciaDetSolicitud() {
        return existenciaDetSolicitud;
    }

    public void setExistenciaDetSolicitud(BigDecimal existenciaDetSolicitud) {
        this.existenciaDetSolicitud = existenciaDetSolicitud;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public TipoProducto getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(TipoProducto codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetSolicitud != null ? codDetSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetSolicitud)) {
            return false;
        }
        DetSolicitud other = (DetSolicitud) object;
        if ((this.codDetSolicitud == null && other.codDetSolicitud != null) || (this.codDetSolicitud != null && !this.codDetSolicitud.equals(other.codDetSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.DetSolicitud[ codDetSolicitud=" + codDetSolicitud + " ]";
    }
    
}
