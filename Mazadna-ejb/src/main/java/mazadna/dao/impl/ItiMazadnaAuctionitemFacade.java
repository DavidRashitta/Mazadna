/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.impl;


import mazadna.dal.entities.ItiMazadnaAuctionitem;
import mazadna.dao.inter.ItiMazadnaAuctionitemFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author szmoh
 */
@Stateless
public class ItiMazadnaAuctionitemFacade extends AbstractFacade<ItiMazadnaAuctionitem> implements ItiMazadnaAuctionitemFacadeLocal {

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaAuctionitemFacade() {
        super(ItiMazadnaAuctionitem.class);
    }
    
}
