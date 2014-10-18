/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.Solicitud;

/**
 *
 * @author DFROZ
 */
@Stateless
public class SolicitudFacade extends AbstractFacade<Solicitud> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudFacade() {
        super(Solicitud.class);
    }
    
    public List<Solicitud> findByCia(Integer codCia){    
    return getEntityManager().createNamedQuery("Solicitud.findAll")
            .setParameter("codCia", codCia)
            .getResultList();
    }
    
    public List<Solicitud> findByCia(Integer codCia, String periodo){    
    return getEntityManager().createNamedQuery("Solicitud.findByPeriodoSolicitud")
            .setParameter("codCia", codCia)
            .setParameter("periodoSolicitud", periodo)
            .getResultList();
    }
    
}
