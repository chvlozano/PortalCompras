/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.MenuRol;

/**
 *
 * @author DFROZ
 */
@Stateless
public class MenuRolFacade extends AbstractFacade<MenuRol> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuRolFacade() {
        super(MenuRol.class);
    }
    
}
