package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaItem;
import mazadna.dal.entities.ItiMazadnaUser;
import mazadna.dao.ItiMazadnaItemFacade;
import mazadna.dao.ItiMazadnaUserFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;

@ManagedBean(name = "dealBean")
@SessionScoped
public class DealBean {

    @EJB
    private ItiMazadnaItemFacade itiMazadnaItemFacade;

    List<ItiMazadnaAuction> deals;

    public DealBean() {

    }

//    DataModel<ItiMazadnaAuction> model = new ListDataModel<ItiMazadnaAuction>(itiMazadnaItemFacade.getAllDeals());

//    public void setModel(DataModel<ItiMazadnaAuction> model) {
//        this.model = model;
//    }
//
//    public DataModel<ItiMazadnaAuction> getModel() {
//        return model;
//    }


    public List<ItiMazadnaAuction> getDeals(){
        deals = itiMazadnaItemFacade.getAllDeals();
        return deals;
    }


}
