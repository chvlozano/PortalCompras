/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "cia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cia.findAll", query = "SELECT c FROM Cia c"),
    @NamedQuery(name = "Cia.findByCodCia", query = "SELECT c FROM Cia c WHERE c.codCia = :codCia"),
    @NamedQuery(name = "Cia.findByRazonSocialCia", query = "SELECT c FROM Cia c WHERE c.razonSocialCia = :razonSocialCia"),
    @NamedQuery(name = "Cia.findByNomComercialCia", query = "SELECT c FROM Cia c WHERE c.nomComercialCia = :nomComercialCia"),
    @NamedQuery(name = "Cia.findByDirecEmpresaCia", query = "SELECT c FROM Cia c WHERE c.direcEmpresaCia = :direcEmpresaCia"),
    @NamedQuery(name = "Cia.findByTelefEmpresaCia", query = "SELECT c FROM Cia c WHERE c.telefEmpresaCia = :telefEmpresaCia"),
    @NamedQuery(name = "Cia.findByNitEmpresaCia", query = "SELECT c FROM Cia c WHERE c.nitEmpresaCia = :nitEmpresaCia"),
    @NamedQuery(name = "Cia.findByNumeroPatronalCia", query = "SELECT c FROM Cia c WHERE c.numeroPatronalCia = :numeroPatronalCia"),
    @NamedQuery(name = "Cia.findByMesCierreCia", query = "SELECT c FROM Cia c WHERE c.mesCierreCia = :mesCierreCia"),
    @NamedQuery(name = "Cia.findByMesProcesoCia", query = "SELECT c FROM Cia c WHERE c.mesProcesoCia = :mesProcesoCia"),
    @NamedQuery(name = "Cia.findByTasaIvaCia", query = "SELECT c FROM Cia c WHERE c.tasaIvaCia = :tasaIvaCia"),
    @NamedQuery(name = "Cia.findByTipoRemuneracionCia", query = "SELECT c FROM Cia c WHERE c.tipoRemuneracionCia = :tipoRemuneracionCia"),
    @NamedQuery(name = "Cia.findByRegistroIvaCia", query = "SELECT c FROM Cia c WHERE c.registroIvaCia = :registroIvaCia"),
    @NamedQuery(name = "Cia.findByGiroCia", query = "SELECT c FROM Cia c WHERE c.giroCia = :giroCia"),
    @NamedQuery(name = "Cia.findByUsuarioCreaCia", query = "SELECT c FROM Cia c WHERE c.usuarioCreaCia = :usuarioCreaCia"),
    @NamedQuery(name = "Cia.findByUsuarioModCia", query = "SELECT c FROM Cia c WHERE c.usuarioModCia = :usuarioModCia"),
    @NamedQuery(name = "Cia.findByFechaCreaCia", query = "SELECT c FROM Cia c WHERE c.fechaCreaCia = :fechaCreaCia"),
    @NamedQuery(name = "Cia.findByFechaModCia", query = "SELECT c FROM Cia c WHERE c.fechaModCia = :fechaModCia"),
    @NamedQuery(name = "Cia.findByRepresentanteCia", query = "SELECT c FROM Cia c WHERE c.representanteCia = :representanteCia"),
    @NamedQuery(name = "Cia.findByContadorCia", query = "SELECT c FROM Cia c WHERE c.contadorCia = :contadorCia"),
    @NamedQuery(name = "Cia.findByAuditorCia", query = "SELECT c FROM Cia c WHERE c.auditorCia = :auditorCia")})
public class Cia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private Integer codCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RAZON_SOCIAL_CIA")
    private String razonSocialCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOM_COMERCIAL_CIA")
    private String nomComercialCia;
    @Size(max = 100)
    @Column(name = "DIREC_EMPRESA_CIA")
    private String direcEmpresaCia;
    @Size(max = 10)
    @Column(name = "TELEF_EMPRESA_CIA")
    private String telefEmpresaCia;
    @Size(max = 15)
    @Column(name = "NIT_EMPRESA_CIA")
    private String nitEmpresaCia;
    @Size(max = 15)
    @Column(name = "NUMERO_PATRONAL_CIA")
    private String numeroPatronalCia;
    @Column(name = "MES_CIERRE_CIA")
    private Short mesCierreCia;
    @Column(name = "MES_PROCESO_CIA")
    private Short mesProcesoCia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TASA_IVA_CIA")
    private BigDecimal tasaIvaCia;
    @Column(name = "TIPO_REMUNERACION_CIA")
    private Short tipoRemuneracionCia;
    @Size(max = 15)
    @Column(name = "REGISTRO_IVA_CIA")
    private String registroIvaCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "GIRO_CIA")
    private String giroCia;
    @Size(max = 50)
    @Column(name = "USUARIO_CREA_CIA")
    private String usuarioCreaCia;
    @Size(max = 50)
    @Column(name = "USUARIO_MOD_CIA")
    private String usuarioModCia;
    @Column(name = "FECHA_CREA_CIA")
    @Temporal(TemporalType.DATE)
    private Date fechaCreaCia;
    @Column(name = "FECHA_MOD_CIA")
    @Temporal(TemporalType.DATE)
    private Date fechaModCia;
    @Size(max = 100)
    @Column(name = "REPRESENTANTE_CIA")
    private String representanteCia;
    @Size(max = 100)
    @Column(name = "CONTADOR_CIA")
    private String contadorCia;
    @Size(max = 100)
    @Column(name = "AUDITOR_CIA")
    private String auditorCia;
    @OneToMany(mappedBy = "codCia")
    private List<Cotizacion> cotizacionList;
    @OneToMany(mappedBy = "codCia")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "codCia")
    private List<Depto> deptoList;
    @OneToMany(mappedBy = "codCia")
    private List<Menu> menuList;
    @OneToMany(mappedBy = "codCia")
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(mappedBy = "codCia")
    private List<Emp> empList;
    @OneToMany(mappedBy = "codCia")
    private List<Solicitud> solicitudList;
    @OneToMany(mappedBy = "codCia")
    private List<ActaAceptacion> actaAceptacionList;
    @OneToMany(mappedBy = "codCia")
    private List<TipoProducto> tipoProductoList;
    @OneToMany(mappedBy = "codCia")
    private List<Producto> productoList;
    @OneToMany(mappedBy = "codCia")
    private List<Unidad> unidadList;
    @OneToMany(mappedBy = "codCia")
    private List<Proveedor> proveedorList;

    public Cia() {
    }

    public Cia(Integer codCia) {
        this.codCia = codCia;
    }

    public Cia(Integer codCia, String razonSocialCia, String nomComercialCia, String giroCia) {
        this.codCia = codCia;
        this.razonSocialCia = razonSocialCia;
        this.nomComercialCia = nomComercialCia;
        this.giroCia = giroCia;
    }

    public Integer getCodCia() {
        return codCia;
    }

    public void setCodCia(Integer codCia) {
        this.codCia = codCia;
    }

    public String getRazonSocialCia() {
        return razonSocialCia;
    }

    public void setRazonSocialCia(String razonSocialCia) {
        this.razonSocialCia = razonSocialCia;
    }

    public String getNomComercialCia() {
        return nomComercialCia;
    }

    public void setNomComercialCia(String nomComercialCia) {
        this.nomComercialCia = nomComercialCia;
    }

    public String getDirecEmpresaCia() {
        return direcEmpresaCia;
    }

    public void setDirecEmpresaCia(String direcEmpresaCia) {
        this.direcEmpresaCia = direcEmpresaCia;
    }

    public String getTelefEmpresaCia() {
        return telefEmpresaCia;
    }

    public void setTelefEmpresaCia(String telefEmpresaCia) {
        this.telefEmpresaCia = telefEmpresaCia;
    }

    public String getNitEmpresaCia() {
        return nitEmpresaCia;
    }

    public void setNitEmpresaCia(String nitEmpresaCia) {
        this.nitEmpresaCia = nitEmpresaCia;
    }

    public String getNumeroPatronalCia() {
        return numeroPatronalCia;
    }

    public void setNumeroPatronalCia(String numeroPatronalCia) {
        this.numeroPatronalCia = numeroPatronalCia;
    }

    public Short getMesCierreCia() {
        return mesCierreCia;
    }

    public void setMesCierreCia(Short mesCierreCia) {
        this.mesCierreCia = mesCierreCia;
    }

    public Short getMesProcesoCia() {
        return mesProcesoCia;
    }

    public void setMesProcesoCia(Short mesProcesoCia) {
        this.mesProcesoCia = mesProcesoCia;
    }

    public BigDecimal getTasaIvaCia() {
        return tasaIvaCia;
    }

    public void setTasaIvaCia(BigDecimal tasaIvaCia) {
        this.tasaIvaCia = tasaIvaCia;
    }

    public Short getTipoRemuneracionCia() {
        return tipoRemuneracionCia;
    }

    public void setTipoRemuneracionCia(Short tipoRemuneracionCia) {
        this.tipoRemuneracionCia = tipoRemuneracionCia;
    }

    public String getRegistroIvaCia() {
        return registroIvaCia;
    }

    public void setRegistroIvaCia(String registroIvaCia) {
        this.registroIvaCia = registroIvaCia;
    }

    public String getGiroCia() {
        return giroCia;
    }

    public void setGiroCia(String giroCia) {
        this.giroCia = giroCia;
    }

    public String getUsuarioCreaCia() {
        return usuarioCreaCia;
    }

    public void setUsuarioCreaCia(String usuarioCreaCia) {
        this.usuarioCreaCia = usuarioCreaCia;
    }

    public String getUsuarioModCia() {
        return usuarioModCia;
    }

    public void setUsuarioModCia(String usuarioModCia) {
        this.usuarioModCia = usuarioModCia;
    }

    public Date getFechaCreaCia() {
        return fechaCreaCia;
    }

    public void setFechaCreaCia(Date fechaCreaCia) {
        this.fechaCreaCia = fechaCreaCia;
    }

    public Date getFechaModCia() {
        return fechaModCia;
    }

    public void setFechaModCia(Date fechaModCia) {
        this.fechaModCia = fechaModCia;
    }

    public String getRepresentanteCia() {
        return representanteCia;
    }

    public void setRepresentanteCia(String representanteCia) {
        this.representanteCia = representanteCia;
    }

    public String getContadorCia() {
        return contadorCia;
    }

    public void setContadorCia(String contadorCia) {
        this.contadorCia = contadorCia;
    }

    public String getAuditorCia() {
        return auditorCia;
    }

    public void setAuditorCia(String auditorCia) {
        this.auditorCia = auditorCia;
    }

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Depto> getDeptoList() {
        return deptoList;
    }

    public void setDeptoList(List<Depto> deptoList) {
        this.deptoList = deptoList;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @XmlTransient
    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<ActaAceptacion> getActaAceptacionList() {
        return actaAceptacionList;
    }

    public void setActaAceptacionList(List<ActaAceptacion> actaAceptacionList) {
        this.actaAceptacionList = actaAceptacionList;
    }

    @XmlTransient
    public List<TipoProducto> getTipoProductoList() {
        return tipoProductoList;
    }

    public void setTipoProductoList(List<TipoProducto> tipoProductoList) {
        this.tipoProductoList = tipoProductoList;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @XmlTransient
    public List<Unidad> getUnidadList() {
        return unidadList;
    }

    public void setUnidadList(List<Unidad> unidadList) {
        this.unidadList = unidadList;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCia != null ? codCia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cia)) {
            return false;
        }
        Cia other = (Cia) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Cia[ codCia=" + codCia + " ]";
    }
    
}
