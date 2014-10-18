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
public class CotizacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_COTIZACION")
    private int codCotizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PERIODO_COTIZACION")
    private String periodoCotizacion;

    public CotizacionPK() {
    }

    public CotizacionPK(int codCotizacion, String periodoCotizacion) {
        this.codCotizacion = codCotizacion;
        this.periodoCotizacion = periodoCotizacion;
    }

    public int getCodCotizacion() {
        return codCotizacion;
    }

    public void setCodCotizacion(int codCotizacion) {
        this.codCotizacion = codCotizacion;
    }

    public String getPeriodoCotizacion() {
        return periodoCotizacion;
    }

    public void setPeriodoCotizacion(String periodoCotizacion) {
        this.periodoCotizacion = periodoCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCotizacion;
        hash += (periodoCotizacion != null ? periodoCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionPK)) {
            return false;
        }
        CotizacionPK other = (CotizacionPK) object;
        if (this.codCotizacion != other.codCotizacion) {
            return false;
        }
        if ((this.periodoCotizacion == null && other.periodoCotizacion != null) || (this.periodoCotizacion != null && !this.periodoCotizacion.equals(other.periodoCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.CotizacionPK[ codCotizacion=" + codCotizacion + ", periodoCotizacion=" + periodoCotizacion + " ]";
    }
    
}
