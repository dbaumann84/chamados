/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.LabLaboratorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author profe
 */
@Stateless
public class LabLaboratorioFacade extends AbstractFacade<LabLaboratorio> {

    @PersistenceContext(unitName = "RevervasUniasselviPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LabLaboratorioFacade() {
        super(LabLaboratorio.class);
    }
    
}
