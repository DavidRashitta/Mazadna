package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaItem;
import mazadna.dal.entities.ItiMazadnaUser;
import mazadna.dao.ItiMazadnaItemFacade;
import mazadna.dao.ItiMazadnaUserFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;

@ManagedBean(name = "dealBean")
@SessionScoped
public class DealBean {

    @EJB
    private ItiMazadnaItemFacade itiMazadnaItemFacade;

    @ManagedProperty(value = "#{itemBean}")
    private ItemBean itemBean;

    List<ItiMazadnaAuction> deals;

    public DealBean() {

    }

    public ItemBean getItemBean() {
        return itemBean;
    }

    public void setItemBean(ItemBean itemBean) {
        this.itemBean = itemBean;
    }
//    DataModel<ItiMazadnaAuction> model = new ListDataModel<ItiMazadnaAuction>(itiMazadnaItemFacade.getAllDeals());

//    public void setModel(DataModel<ItiMazadnaAuction> model) {
//        this.model = model;
//    }
//
//    public DataModel<ItiMazadnaAuction> getModel() {
//        return model;
//    }


    public List<ItiMazadnaAuction> getDeals() {
        deals = itiMazadnaItemFacade.getAllDeals();
        return deals;
    }

    public String findItems(ItiMazadnaAuction auction) {
        this.itemBean.setItiMazadnaAuction(auction);
        return "dealItems";
    }


}
