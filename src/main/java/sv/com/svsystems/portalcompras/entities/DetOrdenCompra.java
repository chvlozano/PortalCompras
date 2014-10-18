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
@Table(name = "det_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetOrdenCompra.findAll", query = "SELECT d FROM DetOrdenCompra d"),
    @NamedQuery(name = "DetOrdenCompra.findByOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.ordenCompra =:ordenCompra"),
    @NamedQuery(name = "DetOrdenCompra.findByCodDetOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.codDetOrdenCompra = :codDetOrdenCompra"),
    @NamedQuery(name = "DetOrdenCompra.findByCantidadDetOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.cantidadDetOrdenCompra = :cantidadDetOrdenCompra"),
    @NamedQuery(name = "DetOrdenCompra.findBySaldoDetOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.saldoDetOrdenCompra = :saldoDetOrdenCompra"),
    @NamedQuery(name = "DetOrdenCompra.findByCostoDetOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.costoDetOrdenCompra = :costoDetOrdenCompra"),
    @NamedQuery(name = "DetOrdenCompra.findByDescripcionDetOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.descripcionDetOrdenCompra = :descripcionDetOrdenCompra"),
    @NamedQuery(name = "DetOrdenCompra.findByUnidadDetOrdenCompra", query = "SELECT d FROM DetOrdenCompra d WHERE d.unidadDetOrdenCompra = :unidadDetOrdenCompra")})
public class DetOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DET_ORDEN_COMPRA")
    private Integer codDetOrdenCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD_DET_ORDEN_COMPRA")
    private BigDecimal cantidadDetOrdenCompra;
    @Column(name = "SALDO_DET_ORDEN_COMPRA")
    private BigDecimal saldoDetOrdenCompra;
    @Column(name = "COSTO_DET_ORDEN_COMPRA")
    private BigDecimal costoDetOrdenCompra;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_DET_ORDEN_COMPRA")
    private String descripcionDetOrdenCompra;
    @Size(max = 250)
    @Column(name = "UNIDAD_DET_ORDEN_COMPRA")
    private String unidadDetOrdenCompra;
    @JoinColumns({
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO"),
        @JoinColumn(name = "COD_ORDEN_COMPRA", referencedColumnName = "COD_ORDEN_COMPRA")})
    @ManyToOne
    private OrdenCompra ordenCompra;
    @JoinColumn(name = "COD_TIPO_PRODUCTO", referencedColumnName = "COD_TIPO_PRODUCTO")
    @ManyToOne
    private TipoProducto codTipoProducto;

    public DetOrdenCompra() {
    }

    public DetOrdenCompra(Integer codDetOrdenCompra) {
        this.codDetOrdenCompra = codDetOrdenCompra;
    }

    public Integer getCodDetOrdenCompra() {
        return codDetOrdenCompra;
    }

    public void setCodDetOrdenCompra(Integer codDetOrdenCompra) {
        this.codDetOrdenCompra = codDetOrdenCompra;
    }

    public BigDecimal getCantidadDetOrdenCompra() {
        return cantidadDetOrdenCompra;
    }

    public void setCantidadDetOrdenCompra(BigDecimal cantidadDetOrdenCompra) {
        this.cantidadDetOrdenCompra = cantidadDetOrdenCompra;
    }

    public BigDecimal getSaldoDetOrdenCompra() {
        return saldoDetOrdenCompra;
    }

    public void setSaldoDetOrdenCompra(BigDecimal saldoDetOrdenCompra) {
        this.saldoDetOrdenCompra = saldoDetOrdenCompra;
    }

    public BigDecimal getCostoDetOrdenCompra() {
        return costoDetOrdenCompra;
    }

    public void setCostoDetOrdenCompra(BigDecimal costoDetOrdenCompra) {
        this.costoDetOrdenCompra = costoDetOrdenCompra;
    }

    public String getDescripcionDetOrdenCompra() {
        return descripcionDetOrdenCompra;
    }

    public void setDescripcionDetOrdenCompra(String descripcionDetOrdenCompra) {
        this.descripcionDetOrdenCompra = descripcionDetOrdenCompra;
    }

    public String getUnidadDetOrdenCompra() {
        return unidadDetOrdenCompra;
    }

    public void setUnidadDetOrdenCompra(String unidadDetOrdenCompra) {
        this.unidadDetOrdenCompra = unidadDetOrdenCompra;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
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
        hash += (codDetOrdenCompra != null ? codDetOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetOrdenCompra)) {
            return false;
        }
        DetOrdenCompra other = (DetOrdenCompra) object;
        if ((this.codDetOrdenCompra == null && other.codDetOrdenCompra != null) || (this.codDetOrdenCompra != null && !this.codDetOrdenCompra.equals(other.codDetOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.DetOrdenCompra[ codDetOrdenCompra=" + codDetOrdenCompra + " ]";
    }
    
}
