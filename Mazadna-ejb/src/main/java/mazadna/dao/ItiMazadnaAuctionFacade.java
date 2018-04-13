/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao;

import mazadna.dal.entities.ItiMazadnaAuction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author szmoh
 */
@Stateless
public class ItiMazadnaAuctionFacade extends AbstractFacade<ItiMazadnaAuction> {

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
