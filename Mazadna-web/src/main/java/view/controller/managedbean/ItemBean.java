package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaItem;
import mazadna.dao.ItiMazadnaItemFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean {
    public ItemBean() {

    }

    private ItiMazadnaAuction itiMazadnaAuction;

    private List<ItiMazadnaItem> items;

    @EJB
    private ItiMazadnaItemFacade itiMazadnaItemFacade;

    public ItiMazadnaAuction getItiMazadnaAuction() {
        return itiMazadnaAuction;
    }

    public void setItiMazadnaAuction(ItiMazadnaAuction itiMazadnaAuction) {
        this.itiMazadnaAuction = itiMazadnaAuction;
    }

    public List<ItiMazadnaItem> getAuctionItems(){
        items = itiMazadnaItemFacade.getItemsOfSpecificAuction(itiMazadnaAuction.getRecid());
        return items;
    }
}
