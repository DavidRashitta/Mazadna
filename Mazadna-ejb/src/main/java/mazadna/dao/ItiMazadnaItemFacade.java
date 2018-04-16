/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao;

;
import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaAuctionitem;
import mazadna.dal.entities.ItiMazadnaItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author szmoh
 */
@Stateless
public class ItiMazadnaItemFacade extends AbstractFacade<ItiMazadnaItem> {

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaItemFacade() {
        super(ItiMazadnaItem.class);
    }

    // get all deals
    //TESTED
    public List<ItiMazadnaAuction> getAllDeals() {
        System.out.println("get all deals");
        Query query1 = em.createQuery("SELECT auctionItem from ItiMazadnaAuctionitem auctionItem " +
                "WHERE  auctionItem.itiMazadnaAuctionitemPK.itemid IN (SELECT item.recid FROM ItiMazadnaItem item WHERE item.userid <> item.supplierid)");

        List<ItiMazadnaAuctionitem> deals = query1.getResultList();

        List<ItiMazadnaAuction> auc = new ArrayList<>();
        for (ItiMazadnaAuctionitem auctionitem : deals){
            Query query2 = em.createQuery("SELECT a from ItiMazadnaAuction a where a.recid = :id");
            query2.setParameter("id",auctionitem.getItiMazadnaAuctionitemPK().getAuctionid());
            auc.add((ItiMazadnaAuction) query2.getSingleResult());
        }

        return auc;
    }
    //to get items of a specific auction
    public List<ItiMazadnaItem> getItemsOfSpecificAuction(long id){
        Query query1 = em.createQuery("SELECT item from ItiMazadnaItem item " +
                "WHERE  item.recid IN " +
                "(SELECT aucItem.itiMazadnaAuctionitemPK.itemid FROM ItiMazadnaAuctionitem aucItem WHERE aucItem.itiMazadnaAuctionitemPK.auctionid = :id)");
        query1.setParameter("id",id);
        List<ItiMazadnaItem> items = query1.getResultList();
        return items;
    }

}
