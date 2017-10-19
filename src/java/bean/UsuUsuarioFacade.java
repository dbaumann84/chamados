/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.UsuUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author profe
 */
@Stateless
public class UsuUsuarioFacade extends AbstractFacade<UsuUsuario> {

    @PersistenceContext(unitName = "RevervasUniasselviPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuUsuarioFacade() {
        super(UsuUsuario.class);
    }
    
}
