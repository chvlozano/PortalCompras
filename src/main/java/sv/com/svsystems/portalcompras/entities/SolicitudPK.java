/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DFROZ
 */
@Embeddable
public class SolicitudPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SOLICITUD")
    private int codSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PERIODO_SOLICITUD")
    private String periodoSolicitud;

    public SolicitudPK() {
    }

    public SolicitudPK(int codSolicitud, String periodoSolicitud) {
        this.codSolicitud = codSolicitud;
        this.periodoSolicitud = periodoSolicitud;
    }

    public int getCodSolicitud() {
        return codSolicitud;
    }

    public void setCodSolicitud(int codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public String getPeriodoSolicitud() {
        return periodoSolicitud;
    }

    public void setPeriodoSolicitud(String periodoSolicitud) {
        this.periodoSolicitud = periodoSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codSolicitud;
        hash += (periodoSolicitud != null ? periodoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudPK)) {
            return false;
        }
        SolicitudPK other = (SolicitudPK) object;
        if (this.codSolicitud != other.codSolicitud) {
            return false;
        }
        if ((this.periodoSolicitud == null && other.periodoSolicitud != null) || (this.periodoSolicitud != null && !this.periodoSolicitud.equals(other.periodoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.SolicitudPK[ codSolicitud=" + codSolicitud + ", periodoSolicitud=" + periodoSolicitud + " ]";
    }
    
}
