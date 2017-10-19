/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.ParParamentros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author profe
 */
@Stateless
public class ParParamentrosFacade extends AbstractFacade<ParParamentros> {

    @PersistenceContext(unitName = "RevervasUniasselviPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParParamentrosFacade() {
        super(ParParamentros.class);
    }
    
}
