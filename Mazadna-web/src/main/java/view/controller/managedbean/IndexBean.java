package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaUser;
import mazadna.dao.ItiMazadnaUserFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "indexBean")
@RequestScoped
public class IndexBean {

    @EJB
    ItiMazadnaUserFacade itiMazadnaUserFacade;

    String name;

    public String getName() {
        name = itiMazadnaUserFacade.getName();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
