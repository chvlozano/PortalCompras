/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.Cia;


/**
 *
 * @author DFROZ
 */
@Stateless
public class CiaFacade extends AbstractFacade<Cia> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiaFacade() {
        super(Cia.class);
    }
    
    public List<Cia> findAll() {
        return getEntityManager().createNamedQuery("cia.findAll")
                .getResultList();
    }
    
    
}
