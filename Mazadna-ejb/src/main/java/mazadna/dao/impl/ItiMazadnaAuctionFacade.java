/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.impl;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dao.inter.ItiMazadnaAuctionFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author szmoh
 */
@Stateless
public class ItiMazadnaAuctionFacade extends AbstractFacade<ItiMazadnaAuction> implements ItiMazadnaAuctionFacadeLocal {

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaAuctionFacade() {
        super(ItiMazadnaAuction.class);
    }
    
}
