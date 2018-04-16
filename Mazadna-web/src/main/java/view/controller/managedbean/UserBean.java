/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaUser;
import mazadna.dao.ItiMazadnaUserFacade;

import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author GhadaMohamed
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserBean {

    @EJB
    private ItiMazadnaUserFacade itiMazadnaUserFacade;

    ItiMazadnaUser currentUser;

    public UserBean() {
        currentUser = new ItiMazadnaUser();
    }

    /**
     * **************** setter and getter for User Obj ****************
     */
    public ItiMazadnaUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(ItiMazadnaUser currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * **************** setter and getter for User Facade ****************
     */
    public ItiMazadnaUserFacade getItiMazadnaUserFacade() {
        return itiMazadnaUserFacade;
    }

    public void setItiMazadnaUserFacade(ItiMazadnaUserFacade itiMazadnaUserFacade) {
        this.itiMazadnaUserFacade = itiMazadnaUserFacade;
    }

    /**
     * ***************************** check login ***********************
     */
    public String checkLogin() {
        String page;
        currentUser = itiMazadnaUserFacade.checkLogin(currentUser.getEmail(), currentUser.getPassword());
        if (currentUser != null) {
            page = "index";
        } else {
            page = "login";
        }
        return page;
    }

    /**
     * ***************************** Register ***********************
     */
    public String register() {
        currentUser.setRecid(0L);
        itiMazadnaUserFacade.create(currentUser);
        return "index";
    }

}
