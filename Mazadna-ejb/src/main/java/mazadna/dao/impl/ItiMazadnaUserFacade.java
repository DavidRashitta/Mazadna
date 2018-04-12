/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.impl;

import mazadna.dal.entities.ItiMazadnaUser;
import mazadna.dao.inter.ItiMazadnaUserFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 *
 * @author szmoh
 */
@Stateless

public class ItiMazadnaUserFacade extends AbstractFacade<ItiMazadnaUser>
        implements ItiMazadnaUserFacadeLocal , Serializable {

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaUserFacade() {
        super(ItiMazadnaUser.class);
    }
    
}
