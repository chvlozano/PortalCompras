/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.DetOrdenCompra;
import sv.com.svsystems.portalcompras.entities.OrdenCompra;

/**
 *
 * @author DFROZ
 */
@Stateless
public class DetOrdenCompraFacade extends AbstractFacade<DetOrdenCompra> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetOrdenCompraFacade() {
        super(DetOrdenCompra.class);
    }
    
    public List<DetOrdenCompra> findByOrdenCompra(OrdenCompra oc){
    
        return getEntityManager().createNamedQuery("DetOrdenCompra.findByOrdenCompra")
                .setParameter("ordenCompra", oc )
                .getResultList();
    }
    
}
