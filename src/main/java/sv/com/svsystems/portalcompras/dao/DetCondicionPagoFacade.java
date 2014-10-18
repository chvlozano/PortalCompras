/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.DetCondicionPago;

/**
 *
 * @author DFROZ
 */
@Stateless
public class DetCondicionPagoFacade extends AbstractFacade<DetCondicionPago> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetCondicionPagoFacade() {
        super(DetCondicionPago.class);
    }
    
}
