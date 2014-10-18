/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.Depto;

/**
 *
 * @author DFROZ
 */
@Stateless
public class DeptoFacade extends AbstractFacade<Depto> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeptoFacade() {
        super(Depto.class);
    }
    
}
