/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.impl;


import mazadna.dal.entities.ItiMazadnaBidderitem;
import mazadna.dao.inter.ItiMazadnaBidderitemFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author szmoh
 */
@Stateless
public class ItiMazadnaBidderitemFacade extends AbstractFacade<ItiMazadnaBidderitem> implements ItiMazadnaBidderitemFacadeLocal {

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaBidderitemFacade() {
        super(ItiMazadnaBidderitem.class);
    }
    
}
