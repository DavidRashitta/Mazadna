/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao;

import mazadna.dal.entities.ItiMazadnaUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author szmoh
 */

@Stateless
public class ItiMazadnaUserFacade extends AbstractFacade<ItiMazadnaUser> {

    String name = "David";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PersistenceContext(unitName = "MazadnaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItiMazadnaUserFacade() {
        super(ItiMazadnaUser.class);
    }

    //if username and password exists return user obj else return null
    public ItiMazadnaUser checkLogin(String email, String password) {
        ItiMazadnaUser user = null;
        Query query = em.createQuery("SELECT u FROM ItiMazadnaUser u where u.email = :email and u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        if (!query.getResultList().isEmpty()) {
            List<ItiMazadnaUser> users = query.getResultList();
            user = users.get(0);
        }
        return user;
    }

}
