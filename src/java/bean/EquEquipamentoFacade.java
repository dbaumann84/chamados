/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.EquEquipamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author profe
 */
@Stateless
public class EquEquipamentoFacade extends AbstractFacade<EquEquipamento> {

    @PersistenceContext(unitName = "RevervasUniasselviPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquEquipamentoFacade() {
        super(EquEquipamento.class);
    }
    
}
