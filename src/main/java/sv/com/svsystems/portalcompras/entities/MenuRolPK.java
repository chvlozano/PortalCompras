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

/**
 *
 * @author DFROZ
 */
@Embeddable
public class MenuRolPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ROL")
    private int codRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MENU")
    private int codMenu;

    public MenuRolPK() {
    }

    public MenuRolPK(int codCia, int codRol, int codMenu) {
        this.codCia = codCia;
        this.codRol = codRol;
        this.codMenu = codMenu;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCodRol() {
        return codRol;
    }

    public void setCodRol(int codRol) {
        this.codRol = codRol;
    }

    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codRol;
        hash += (int) codMenu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuRolPK)) {
            return false;
        }
        MenuRolPK other = (MenuRolPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codRol != other.codRol) {
            return false;
        }
        if (this.codMenu != other.codMenu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.MenuRolPK[ codCia=" + codCia + ", codRol=" + codRol + ", codMenu=" + codMenu + " ]";
    }
    
}
