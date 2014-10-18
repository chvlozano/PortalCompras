/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.svsystems.portalcompras.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.svsystems.portalcompras.entities.CondicionPago;

/**
 *
 * @author DFROZ
 */
@Stateless
public class CondicionPagoFacade extends AbstractFacade<CondicionPago> {

    @PersistenceContext(unitName = "comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CondicionPagoFacade() {
        super(CondicionPago.class);
    }

    /*Este método no recibe ningún parametro pues no tenemos 
     Condiciones de pago por companias asi que recuperamos todo.
     Este resultado lo agregaremos en los combobox para seleccionar
     Las condiciones de pago.*/
    @Override
    public List<CondicionPago> findAll() {
        return getEntityManager().createNamedQuery("CondicionPago.findAll")
                .getResultList();
    }

    /*
     * Este seria un ejemplo con parámetros.
     * Al invocar este método obligatoriamente tendríamos que pasarle 
     * una valor tipo String y ese valor se pasará a la consulta     
     */
    public List<CondicionPago> find(String tipoPago) {
        return getEntityManager().createNamedQuery("CondicionPago.findByTipoCondicionPago")
                .setParameter("tipoCondicionPago", tipoPago)
                .getResultList();
    }
}
