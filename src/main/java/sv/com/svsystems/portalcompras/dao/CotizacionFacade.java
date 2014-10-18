/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.Cotizacion;
import sv.com.svsystems.portalcompras.entities.CotizacionPK;

/**
 *
 * @author DFROZ
 */
@Stateless
public class CotizacionFacade extends AbstractFacade<Cotizacion> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CotizacionFacade() {
        super(Cotizacion.class);
    }
    
    public List<Cotizacion> findByCia(Integer codCia){
    return getEntityManager().createNamedQuery("Cotizacion.findByCia")
            .setParameter("codCia", codCia)
            .getResultList();
    }        
    
    public List<Cotizacion> findByPeriodo(Integer codCia, String periodo){
    return getEntityManager().createNamedQuery("Cotizacion.findByPeriodoCotizacion")
            .setParameter("codCia", codCia)
            .setParameter("periodoCotizacion", periodo)
            .getResultList();    
           
    }
    
}
