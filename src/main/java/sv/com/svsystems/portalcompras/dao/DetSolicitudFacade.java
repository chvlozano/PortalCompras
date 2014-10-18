/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.DetSolicitud;
import sv.com.svsystems.portalcompras.entities.Solicitud;

/**
 *
 * @author DFROZ
 */
@Stateless
public class DetSolicitudFacade extends AbstractFacade<DetSolicitud> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetSolicitudFacade() {
        super(DetSolicitud.class);
    }
    
    public List<DetSolicitud> findBySolicitud(Solicitud s){
    return getEntityManager().createNamedQuery("DetSolicitud.findBySolicitud")
            .setParameter("solicitud", s)
            .getResultList();
    }
    
}
