/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "menu_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuRol.findAll", query = "SELECT m FROM MenuRol m"),
    @NamedQuery(name = "MenuRol.findByCodCia", query = "SELECT m FROM MenuRol m WHERE m.menuRolPK.codCia = :codCia"),
    @NamedQuery(name = "MenuRol.findByCodRol", query = "SELECT m FROM MenuRol m WHERE m.menuRolPK.codRol = :codRol"),
    @NamedQuery(name = "MenuRol.findByCodMenu", query = "SELECT m FROM MenuRol m WHERE m.menuRolPK.codMenu = :codMenu")})
public class MenuRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuRolPK menuRolPK;

    public MenuRol() {
    }

    public MenuRol(MenuRolPK menuRolPK) {
        this.menuRolPK = menuRolPK;
    }

    public MenuRol(int codCia, int codRol, int codMenu) {
        this.menuRolPK = new MenuRolPK(codCia, codRol, codMenu);
    }

    public MenuRolPK getMenuRolPK() {
        return menuRolPK;
    }

    public void setMenuRolPK(MenuRolPK menuRolPK) {
        this.menuRolPK = menuRolPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuRolPK != null ? menuRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuRol)) {
            return false;
        }
        MenuRol other = (MenuRol) object;
        if ((this.menuRolPK == null && other.menuRolPK != null) || (this.menuRolPK != null && !this.menuRolPK.equals(other.menuRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.MenuRol[ menuRolPK=" + menuRolPK + " ]";
    }
    
}
