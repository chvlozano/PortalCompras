/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "det_condicion_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetCondicionPago.findAll", query = "SELECT d FROM DetCondicionPago d"),
    @NamedQuery(name = "DetCondicionPago.findByTipoCondicionPago", query = "SELECT d FROM DetCondicionPago d WHERE d.tipoCondicionPago = :tipoCondicionPago"),
    @NamedQuery(name = "DetCondicionPago.findByFrecuenciaDetCondicionPago", query = "SELECT d FROM DetCondicionPago d WHERE d.frecuenciaDetCondicionPago = :frecuenciaDetCondicionPago"),
    @NamedQuery(name = "DetCondicionPago.findByDiasDetCondicionPago", query = "SELECT d FROM DetCondicionPago d WHERE d.diasDetCondicionPago = :diasDetCondicionPago")})
public class DetCondicionPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_CONDICION_PAGO")
    private String tipoCondicionPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRECUENCIA_DET_CONDICION_PAGO")
    private int frecuenciaDetCondicionPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIAS_DET_CONDICION_PAGO")
    private int diasDetCondicionPago;
    @JoinColumn(name = "TIPO_CONDICION_PAGO", referencedColumnName = "TIPO_CONDICION_PAGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CondicionPago condicionPago;

    public DetCondicionPago() {
    }

    public DetCondicionPago(String tipoCondicionPago) {
        this.tipoCondicionPago = tipoCondicionPago;
    }

    public DetCondicionPago(String tipoCondicionPago, int frecuenciaDetCondicionPago, int diasDetCondicionPago) {
        this.tipoCondicionPago = tipoCondicionPago;
        this.frecuenciaDetCondicionPago = frecuenciaDetCondicionPago;
        this.diasDetCondicionPago = diasDetCondicionPago;
    }

    public String getTipoCondicionPago() {
        return tipoCondicionPago;
    }

    public void setTipoCondicionPago(String tipoCondicionPago) {
        this.tipoCondicionPago = tipoCondicionPago;
    }

    public int getFrecuenciaDetCondicionPago() {
        return frecuenciaDetCondicionPago;
    }

    public void setFrecuenciaDetCondicionPago(int frecuenciaDetCondicionPago) {
        this.frecuenciaDetCondicionPago = frecuenciaDetCondicionPago;
    }

    public int getDiasDetCondicionPago() {
        return diasDetCondicionPago;
    }

    public void setDiasDetCondicionPago(int diasDetCondicionPago) {
        this.diasDetCondicionPago = diasDetCondicionPago;
    }

    public CondicionPago getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(CondicionPago condicionPago) {
        this.condicionPago = condicionPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCondicionPago != null ? tipoCondicionPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetCondicionPago)) {
            return false;
        }
        DetCondicionPago other = (DetCondicionPago) object;
        if ((this.tipoCondicionPago == null && other.tipoCondicionPago != null) || (this.tipoCondicionPago != null && !this.tipoCondicionPago.equals(other.tipoCondicionPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.DetCondicionPago[ tipoCondicionPago=" + tipoCondicionPago + " ]";
    }
    
}
