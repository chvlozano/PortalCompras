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
@Table(name = "tipo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t"),
    @NamedQuery(name = "TipoProducto.findByCodTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.codTipoProducto = :codTipoProducto"),
    @NamedQuery(name = "TipoProducto.findByNombreTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.nombreTipoProducto = :nombreTipoProducto"),
    @NamedQuery(name = "TipoProducto.findByNombreCortoTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.nombreCortoTipoProducto = :nombreCortoTipoProducto"),
    @NamedQuery(name = "TipoProducto.findByDescripcionTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.descripcionTipoProducto = :descripcionTipoProducto")})
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_PRODUCTO")
    private Integer codTipoProducto;
    @Size(max = 1000)
    @Column(name = "NOMBRE_TIPO_PRODUCTO")
    private String nombreTipoProducto;
    @Size(max = 500)
    @Column(name = "NOMBRE_CORTO_TIPO_PRODUCTO")
    private String nombreCortoTipoProducto;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_TIPO_PRODUCTO")
    private String descripcionTipoProducto;
    @OneToMany(mappedBy = "codTipoProducto")
    private List<DetOrdenCompra> detOrdenCompraList;
    @OneToMany(mappedBy = "codTipoProducto")
    private List<DetSolicitud> detSolicitudList;
    @OneToMany(mappedBy = "codTipoProducto")
    private List<DetCotizacion> detCotizacionList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;

    public TipoProducto() {
    }

    public TipoProducto(Integer codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public Integer getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(Integer codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public String getNombreCortoTipoProducto() {
        return nombreCortoTipoProducto;
    }

    public void setNombreCortoTipoProducto(String nombreCortoTipoProducto) {
        this.nombreCortoTipoProducto = nombreCortoTipoProducto;
    }

    public String getDescripcionTipoProducto() {
        return descripcionTipoProducto;
    }

    public void setDescripcionTipoProducto(String descripcionTipoProducto) {
        this.descripcionTipoProducto = descripcionTipoProducto;
    }

    @XmlTransient
    public List<DetOrdenCompra> getDetOrdenCompraList() {
        return detOrdenCompraList;
    }

    public void setDetOrdenCompraList(List<DetOrdenCompra> detOrdenCompraList) {
        this.detOrdenCompraList = detOrdenCompraList;
    }

    @XmlTransient
    public List<DetSolicitud> getDetSolicitudList() {
        return detSolicitudList;
    }

    public void setDetSolicitudList(List<DetSolicitud> detSolicitudList) {
        this.detSolicitudList = detSolicitudList;
    }

    @XmlTransient
    public List<DetCotizacion> getDetCotizacionList() {
        return detCotizacionList;
    }

    public void setDetCotizacionList(List<DetCotizacion> detCotizacionList) {
        this.detCotizacionList = detCotizacionList;
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
        hash += (codTipoProducto != null ? codTipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.codTipoProducto == null && other.codTipoProducto != null) || (this.codTipoProducto != null && !this.codTipoProducto.equals(other.codTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.TipoProducto[ codTipoProducto=" + codTipoProducto + " ]";
    }
    
}
