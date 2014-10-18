/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByCodUnidad", query = "SELECT u FROM Unidad u WHERE u.codUnidad = :codUnidad"),
    @NamedQuery(name = "Unidad.findByNombreUnidad", query = "SELECT u FROM Unidad u WHERE u.nombreUnidad = :nombreUnidad"),
    @NamedQuery(name = "Unidad.findByCantidadUnidad", query = "SELECT u FROM Unidad u WHERE u.cantidadUnidad = :cantidadUnidad"),
    @NamedQuery(name = "Unidad.findByAbreviaturaUnidad", query = "SELECT u FROM Unidad u WHERE u.abreviaturaUnidad = :abreviaturaUnidad")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_UNIDAD")
    private Integer codUnidad;
    @Size(max = 500)
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD_UNIDAD")
    private BigDecimal cantidadUnidad;
    @Size(max = 15)
    @Column(name = "ABREVIATURA_UNIDAD")
    private String abreviaturaUnidad;
    @OneToMany(mappedBy = "codUnidad")
    private List<DetCotizacion> detCotizacionList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;

    public Unidad() {
    }

    public Unidad(Integer codUnidad) {
        this.codUnidad = codUnidad;
    }

    public Integer getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Integer codUnidad) {
        this.codUnidad = codUnidad;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public BigDecimal getCantidadUnidad() {
        return cantidadUnidad;
    }

    public void setCantidadUnidad(BigDecimal cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }

    public String getAbreviaturaUnidad() {
        return abreviaturaUnidad;
    }

    public void setAbreviaturaUnidad(String abreviaturaUnidad) {
        this.abreviaturaUnidad = abreviaturaUnidad;
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
        hash += (codUnidad != null ? codUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.codUnidad == null && other.codUnidad != null) || (this.codUnidad != null && !this.codUnidad.equals(other.codUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Unidad[ codUnidad=" + codUnidad + " ]";
    }
    
}
