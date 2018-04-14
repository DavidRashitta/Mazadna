/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaItem;

import javax.ejb.Stateless;
import javax.persistence.*;
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

    public List<ItiMazadnaItem> getAuctionItems(int AuctionId){
        Query query = em.createQuery("SELECT i FROM ItiMazadnaItem i WHERE i.recid IN " +
                "(SELECT auctionItem.itiMazadnaAuctionitemPK.itemid FROM ItiMazadnaAuctionitem auctionItem WHERE auctionItem.itiMazadnaAuctionitemPK.auctionid =: id)");
//        Query query = em.createQuery("SELECT i FROM ItiMazadnaItem i WHERE i.recid = :id");
                query.setParameter("id", AuctionId);
        List<ItiMazadnaItem> items = query.getResultList();
        return items;
    }
}
