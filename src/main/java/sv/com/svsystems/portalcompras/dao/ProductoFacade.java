/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.Producto;

/**
 *
 * @author DFROZ
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
   public List<Producto> findByCia(Integer codCia){
   return getEntityManager().createNamedQuery("Producto.findAll").setParameter("codCia", codCia).getResultList();
   
   }
    
    
    
}
