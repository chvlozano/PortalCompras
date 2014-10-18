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
import sv.com.svsystems.portalcompras.entities.DetCotizacion;

/**
 *
 * @author DFROZ
 */
@Stateless
public class DetCotizacionFacade extends AbstractFacade<DetCotizacion> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetCotizacionFacade() {
        super(DetCotizacion.class);
    }
    
    public List<DetCotizacionFacade> findByCotizacion(Cotizacion c){
    
    return getEntityManager().createNamedQuery("DetCotizacion.findByCotizacion")
            .setParameter("cotizacion", c)
            .getResultList();
    
    }
    
    
}
