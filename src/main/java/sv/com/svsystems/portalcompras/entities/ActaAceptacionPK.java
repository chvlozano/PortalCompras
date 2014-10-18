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
public class ActaAceptacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PERIODO_ACTA_ACEPTACION")
    private String periodoActaAceptacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ACTA_ACEPTACION")
    private int codActaAceptacion;

    public ActaAceptacionPK() {
    }

    public ActaAceptacionPK(String periodoActaAceptacion, int codActaAceptacion) {
        this.periodoActaAceptacion = periodoActaAceptacion;
        this.codActaAceptacion = codActaAceptacion;
    }

    public String getPeriodoActaAceptacion() {
        return periodoActaAceptacion;
    }

    public void setPeriodoActaAceptacion(String periodoActaAceptacion) {
        this.periodoActaAceptacion = periodoActaAceptacion;
    }

    public int getCodActaAceptacion() {
        return codActaAceptacion;
    }

    public void setCodActaAceptacion(int codActaAceptacion) {
        this.codActaAceptacion = codActaAceptacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodoActaAceptacion != null ? periodoActaAceptacion.hashCode() : 0);
        hash += (int) codActaAceptacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActaAceptacionPK)) {
            return false;
        }
        ActaAceptacionPK other = (ActaAceptacionPK) object;
        if ((this.periodoActaAceptacion == null && other.periodoActaAceptacion != null) || (this.periodoActaAceptacion != null && !this.periodoActaAceptacion.equals(other.periodoActaAceptacion))) {
            return false;
        }
        if (this.codActaAceptacion != other.codActaAceptacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.ActaAceptacionPK[ periodoActaAceptacion=" + periodoActaAceptacion + ", codActaAceptacion=" + codActaAceptacion + " ]";
    }
    
}
