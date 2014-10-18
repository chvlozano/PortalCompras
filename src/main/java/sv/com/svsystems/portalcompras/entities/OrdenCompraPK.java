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
public class OrdenCompraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PERIODO")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ORDEN_COMPRA")
    private int codOrdenCompra;

    public OrdenCompraPK() {
    }

    public OrdenCompraPK(String periodo, int codOrdenCompra) {
        this.periodo = periodo;
        this.codOrdenCompra = codOrdenCompra;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getCodOrdenCompra() {
        return codOrdenCompra;
    }

    public void setCodOrdenCompra(int codOrdenCompra) {
        this.codOrdenCompra = codOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (int) codOrdenCompra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraPK)) {
            return false;
        }
        OrdenCompraPK other = (OrdenCompraPK) object;
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if (this.codOrdenCompra != other.codOrdenCompra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.OrdenCompraPK[ periodo=" + periodo + ", codOrdenCompra=" + codOrdenCompra + " ]";
    }
    
}
