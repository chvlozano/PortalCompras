/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "archivo_espc_tecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivoEspcTecnica.findAll", query = "SELECT a FROM ArchivoEspcTecnica a"),
    @NamedQuery(name = "ArchivoEspcTecnica.findByCodArchivoEspcTecnica", query = "SELECT a FROM ArchivoEspcTecnica a WHERE a.codArchivoEspcTecnica = :codArchivoEspcTecnica"),
    @NamedQuery(name = "ArchivoEspcTecnica.findByRutaArchivoEspcTecnica", query = "SELECT a FROM ArchivoEspcTecnica a WHERE a.rutaArchivoEspcTecnica = :rutaArchivoEspcTecnica"),
    @NamedQuery(name = "ArchivoEspcTecnica.findByNombreArchivoEspcTecnica", query = "SELECT a FROM ArchivoEspcTecnica a WHERE a.nombreArchivoEspcTecnica = :nombreArchivoEspcTecnica"),
    @NamedQuery(name = "ArchivoEspcTecnica.findByActualizacionArchivoEspcTecnica", query = "SELECT a FROM ArchivoEspcTecnica a WHERE a.actualizacionArchivoEspcTecnica = :actualizacionArchivoEspcTecnica"),
    @NamedQuery(name = "ArchivoEspcTecnica.findByTipoArchivoEspcTecnica", query = "SELECT a FROM ArchivoEspcTecnica a WHERE a.tipoArchivoEspcTecnica = :tipoArchivoEspcTecnica")})
public class ArchivoEspcTecnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ARCHIVO_ESPC_TECNICA")
    private Integer codArchivoEspcTecnica;
    @Size(max = 200)
    @Column(name = "RUTA_ARCHIVO_ESPC_TECNICA")
    private String rutaArchivoEspcTecnica;
    @Size(max = 250)
    @Column(name = "NOMBRE_ARCHIVO_ESPC_TECNICA")
    private String nombreArchivoEspcTecnica;
    @Column(name = "ACTUALIZACION_ARCHIVO_ESPC_TECNICA")
    @Temporal(TemporalType.DATE)
    private Date actualizacionArchivoEspcTecnica;
    @Column(name = "TIPO_ARCHIVO_ESPC_TECNICA")
    private Short tipoArchivoEspcTecnica;
    @JoinColumns({
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO"),
        @JoinColumn(name = "COD_ORDEN_COMPRA", referencedColumnName = "COD_ORDEN_COMPRA")})
    @ManyToOne
    private OrdenCompra ordenCompra;

    public ArchivoEspcTecnica() {
    }

    public ArchivoEspcTecnica(Integer codArchivoEspcTecnica) {
        this.codArchivoEspcTecnica = codArchivoEspcTecnica;
    }

    public Integer getCodArchivoEspcTecnica() {
        return codArchivoEspcTecnica;
    }

    public void setCodArchivoEspcTecnica(Integer codArchivoEspcTecnica) {
        this.codArchivoEspcTecnica = codArchivoEspcTecnica;
    }

    public String getRutaArchivoEspcTecnica() {
        return rutaArchivoEspcTecnica;
    }

    public void setRutaArchivoEspcTecnica(String rutaArchivoEspcTecnica) {
        this.rutaArchivoEspcTecnica = rutaArchivoEspcTecnica;
    }

    public String getNombreArchivoEspcTecnica() {
        return nombreArchivoEspcTecnica;
    }

    public void setNombreArchivoEspcTecnica(String nombreArchivoEspcTecnica) {
        this.nombreArchivoEspcTecnica = nombreArchivoEspcTecnica;
    }

    public Date getActualizacionArchivoEspcTecnica() {
        return actualizacionArchivoEspcTecnica;
    }

    public void setActualizacionArchivoEspcTecnica(Date actualizacionArchivoEspcTecnica) {
        this.actualizacionArchivoEspcTecnica = actualizacionArchivoEspcTecnica;
    }

    public Short getTipoArchivoEspcTecnica() {
        return tipoArchivoEspcTecnica;
    }

    public void setTipoArchivoEspcTecnica(Short tipoArchivoEspcTecnica) {
        this.tipoArchivoEspcTecnica = tipoArchivoEspcTecnica;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArchivoEspcTecnica != null ? codArchivoEspcTecnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoEspcTecnica)) {
            return false;
        }
        ArchivoEspcTecnica other = (ArchivoEspcTecnica) object;
        if ((this.codArchivoEspcTecnica == null && other.codArchivoEspcTecnica != null) || (this.codArchivoEspcTecnica != null && !this.codArchivoEspcTecnica.equals(other.codArchivoEspcTecnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.ArchivoEspcTecnica[ codArchivoEspcTecnica=" + codArchivoEspcTecnica + " ]";
    }
    
}
