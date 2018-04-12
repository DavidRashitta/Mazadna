/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.impl;
;
import mazadna.dal.entities.ItiMazadnaItem;
import mazadna.dao.inter.ItiMazadnaItemFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author szmoh
 */
@Stateless
public class ItiMazadnaItemFacade extends AbstractFacade<ItiMazadnaItem> implements ItiMazadnaItemFacadeLocal {

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaItemFacade() {
        super(ItiMazadnaItem.class);
    }
    
}
