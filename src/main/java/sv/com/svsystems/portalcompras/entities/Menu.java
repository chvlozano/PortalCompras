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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DFROZ
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByCodMenu", query = "SELECT m FROM Menu m WHERE m.codMenu = :codMenu"),
    @NamedQuery(name = "Menu.findByNomMenu", query = "SELECT m FROM Menu m WHERE m.nomMenu = :nomMenu"),
    @NamedQuery(name = "Menu.findByLinkMenu", query = "SELECT m FROM Menu m WHERE m.linkMenu = :linkMenu")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MENU")
    private Integer codMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "NOM_MENU")
    private String nomMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "LINK_MENU")
    private String linkMenu;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cia codCia;

    public Menu() {
    }

    public Menu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public Menu(Integer codMenu, String nomMenu, String linkMenu) {
        this.codMenu = codMenu;
        this.nomMenu = nomMenu;
        this.linkMenu = linkMenu;
    }

    public Integer getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public String getLinkMenu() {
        return linkMenu;
    }

    public void setLinkMenu(String linkMenu) {
        this.linkMenu = linkMenu;
    }

    public Cia getCodCia() {
        return codCia;
    }

    public void setCodCia(Cia codCia) {
        this.codCia = codCia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMenu != null ? codMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.codMenu == null && other.codMenu != null) || (this.codMenu != null && !this.codMenu.equals(other.codMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.svsystems.portalcompras.entities.Menu[ codMenu=" + codMenu + " ]";
    }
    
}
