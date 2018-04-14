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
import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
    public ItiMazadnaAuction getLastAuction() {
        Query query = em.createQuery("select t from ItiMazadnaAuction t order by t.recid desc");
        List<ItiMazadnaAuction> auctions = query.getResultList();
        return auctions.get(0);
    }

    public void addAuction(ItiMazadnaAuction auction) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ItiMazadnaAuction>> constraintViolations = validator.validate(auction);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<ItiMazadnaAuction>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<ItiMazadnaAuction> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage()); }
        } else {
            getEntityManager().persist(auction);
        }
    }
}
