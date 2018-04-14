/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao;

;
import mazadna.dal.entities.ItiMazadnaItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public List<ItiMazadnaItem> getAllDeals() {
        System.out.println("get all deals");
        Query query = em.createQuery("SELECT i FROM ItiMazadnaItem i where i.userid != i.supplierid");
        List<ItiMazadnaItem> deals = query.getResultList();
        return deals;
    }

}
