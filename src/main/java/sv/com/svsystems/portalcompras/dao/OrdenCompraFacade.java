/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.OrdenCompra;

/**
 *
 * @author DFROZ
 */
@Stateless
public class OrdenCompraFacade extends AbstractFacade<OrdenCompra> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenCompraFacade() {
        super(OrdenCompra.class);
    }
    
    public List<OrdenCompra> findByCia(Integer codCia){    
        return getEntityManager().createNamedQuery("OrdenCompra.findAll")
            .setParameter("codCia", codCia)
            .getResultList();
    }
    
    public List<OrdenCompra> findByCia(Integer codCia, String periodo){    
        return getEntityManager().createNamedQuery("OrdenCompra.findByPeriodoSolicitud")
            .setParameter("codCia", codCia)
            .setParameter("periodo", periodo)
            .getResultList();
    }
    
}
