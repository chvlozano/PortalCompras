/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
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
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s WHERE s.codCia =:codCia"),
    @NamedQuery(name = "Solicitud.findByCodSolicitud", query = "SELECT s FROM Solicitud s WHERE s.solicitudPK.codSolicitud = :codSolicitud"),
    @NamedQuery(name = "Solicitud.findByPeriodoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.codCia =:codCia AND s.solicitudPK.periodoSolicitud = :periodoSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Solicitud.findByEstadoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.estadoSolicitud = :estadoSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaRequeridaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaRequeridaSolicitud = :fechaRequeridaSolicitud"),
    @NamedQuery(name = "Solicitud.findByUsoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.usoSolicitud = :usoSolicitud"),
    @NamedQuery(name = "Solicitud.findByDuracionSolicitud", query = "SELECT s FROM Solicitud s WHERE s.duracionSolicitud = :duracionSolicitud"),
    @NamedQuery(name = "Solicitud.findByObservacionSolicitud", query = "SELECT s FROM Solicitud s WHERE s.observacionSolicitud = :observacionSolicitud"),
    @NamedQuery(name = "Solicitud.findByAprobadoPorSolicitud", query = "SELECT s FROM Solicitud s WHERE s.aprobadoPorSolicitud = :aprobadoPorSolicitud"),
    @NamedQuery(name = "Solicitud.findByProyectoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.proyectoSolicitud = :proyectoSolicitud")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudPK solicitudPK;
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "ESTADO_SOLICITUD")
    private Short estadoSolicitud;
    @Column(name = "FECHA_REQUERIDA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaRequeridaSolicitud;
    @Size(max = 250)
    @Column(name = "USO_SOLICITUD")
    private String usoSolicitud;
    @Column(name = "DURACION_SOLICITUD")
    private Integer duracionSolicitud;
    @Size(max = 2000)
    @Column(name = "OBSERVACION_SOLICITUD")
    private String observacionSolicitud;
    @Size(max = 2000)
    @Column(name = "APROBADO_POR_SOLICITUD")
    private String aprobadoPorSolicitud;
    @Size(max = 1000)
    @Column(name = "PROYECTO_SOLICITUD")
    private String proyectoSolicitud;
    @OneToMany(mappedBy = "solicitud")
    private List<DetSolicitud> detSolicitudList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;
    @OneToMany(mappedBy = "solicitud")
    private List<DetCotizacion> detCotizacionList;

    public Solicitud() {
    }

    public Solicitud(SolicitudPK solicitudPK) {
        this.solicitudPK = solicitudPK;
    }

    public Solicitud(int codSolicitud, String periodoSolicitud) {
        this.solicitudPK = new SolicitudPK(codSolicitud, periodoSolicitud);
    }

    public SolicitudPK getSolicitudPK() {
        return solicitudPK;
    }

    public void setSolicitudPK(SolicitudPK solicitudPK) {
        this.solicitudPK = solicitudPK;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Short getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Short estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Date getFechaRequeridaSolicitud() {
        return fechaRequeridaSolicitud;
    }

    public void setFechaRequeridaSolicitud(Date fechaRequeridaSolicitud) {
        this.fechaRequeridaSolicitud = fechaRequeridaSolicitud;
    }

    public String getUsoSolicitud() {
        return usoSolicitud;
    }

    public void setUsoSolicitud(String usoSolicitud) {
        this.usoSolicitud = usoSolicitud;
    }

    public Integer getDuracionSolicitud() {
        return duracionSolicitud;
    }

    public void setDuracionSolicitud(Integer duracionSolicitud) {
        this.duracionSolicitud = duracionSolicitud;
    }

    public String getObservacionSolicitud() {
        return observacionSolicitud;
    }

    public void setObservacionSolicitud(String observacionSolicitud) {
        this.observacionSolicitud = observacionSolicitud;
    }

    public String getAprobadoPorSolicitud() {
        return aprobadoPorSolicitud;
    }

    public void setAprobadoPorSolicitud(String aprobadoPorSolicitud) {
        this.aprobadoPorSolicitud = aprobadoPorSolicitud;
    }

    public String getProyectoSolicitud() {
        return proyectoSolicitud;
    }

    public void setProyectoSolicitud(String proyectoSolicitud) {
        this.proyectoSolicitud = proyectoSolicitud;
    }

    @XmlTransient
    public List<DetSolicitud> getDetSolicitudList() {
        return detSolicitudList;
    }

    public void setDetSolicitudList(List<DetSolicitud> detSolicitudList) {
        this.detSolicitudList = detSolicitudList;
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
        hash += (solicitudPK != null ? solicitudPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.solicitudPK == null && other.solicitudPK != null) || (this.solicitudPK != null && !this.solicitudPK.equals(other.solicitudPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Solicitud[ solicitudPK=" + solicitudPK + " ]";
    }
    
}
