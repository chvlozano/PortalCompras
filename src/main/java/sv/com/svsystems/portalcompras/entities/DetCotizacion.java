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
@Table(name = "det_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetCotizacion.findAll", query = "SELECT d FROM DetCotizacion d WHERE d.cotizacion.codCia =:codCia"),
    @NamedQuery(name = "DetCotizacion.findByCotizacion", query = "SELECT d FROM DetCotizacion d WHERE d.cotizacion =:cotizacion"),
    @NamedQuery(name = "DetCotizacion.findByCodDetCotizacion", query = "SELECT d FROM DetCotizacion d WHERE d.codDetCotizacion =:codDetCotizacion"),
    @NamedQuery(name = "DetCotizacion.findByDescripcionDetCotizacion", query = "SELECT d FROM DetCotizacion d WHERE d.descripcionDetCotizacion =:descripcionDetCotizacion"),
    @NamedQuery(name = "DetCotizacion.findByCantidad", query = "SELECT d FROM DetCotizacion d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetCotizacion.findByPrecio", query = "SELECT d FROM DetCotizacion d WHERE d.precio = :precio"),
    @NamedQuery(name = "DetCotizacion.findByEstado", query = "SELECT d FROM DetCotizacion d WHERE d.estado = :estado")})
public class DetCotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DET_COTIZACION")
    private Integer codDetCotizacion;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION_DET_COTIZACION")
    private String descripcionDetCotizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Size(max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;
    @JoinColumn(name = "COD_TIPO_PRODUCTO", referencedColumnName = "COD_TIPO_PRODUCTO")
    @ManyToOne
    private TipoProducto codTipoProducto;
    @JoinColumns({
        @JoinColumn(name = "COD_SOLICITUD", referencedColumnName = "COD_SOLICITUD"),
        @JoinColumn(name = "PERIODO_SOLICITUD", referencedColumnName = "PERIODO_SOLICITUD")})
    @ManyToOne
    private Solicitud solicitud;
    @JoinColumns({
        @JoinColumn(name = "COD_COTIZACION", referencedColumnName = "COD_COTIZACION"),
        @JoinColumn(name = "PERIODO_COTIZACION", referencedColumnName = "PERIODO_COTIZACION")})
    @ManyToOne
    private Cotizacion cotizacion;
    @JoinColumn(name = "COD_UNIDAD", referencedColumnName = "COD_UNIDAD")
    @ManyToOne
    private Unidad codUnidad;

    public DetCotizacion() {
    }

    public DetCotizacion(Integer codDetCotizacion) {
        this.codDetCotizacion = codDetCotizacion;
    }

    public Integer getCodDetCotizacion() {
        return codDetCotizacion;
    }

    public void setCodDetCotizacion(Integer codDetCotizacion) {
        this.codDetCotizacion = codDetCotizacion;
    }

    public String getDescripcionDetCotizacion() {
        return descripcionDetCotizacion;
    }

    public void setDescripcionDetCotizacion(String descripcionDetCotizacion) {
        this.descripcionDetCotizacion = descripcionDetCotizacion;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public TipoProducto getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(TipoProducto codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Unidad getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Unidad codUnidad) {
        this.codUnidad = codUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetCotizacion != null ? codDetCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetCotizacion)) {
            return false;
        }
        DetCotizacion other = (DetCotizacion) object;
        if ((this.codDetCotizacion == null && other.codDetCotizacion != null) || (this.codDetCotizacion != null && !this.codDetCotizacion.equals(other.codDetCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.DetCotizacion[ codDetCotizacion=" + codDetCotizacion + " ]";
    }
    
}
