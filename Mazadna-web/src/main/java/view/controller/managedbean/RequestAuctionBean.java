package view.controller.managedbean;

import mazadna.dal.entities.*;
import mazadna.dao.ItiMazadnaAuctionFacade;
import mazadna.dao.ItiMazadnaAuctionitemFacade;
import mazadna.dao.ItiMazadnaItemFacade;
import mazadna.dao.ItiMazadnaUserFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "requestAuctionBean")
@RequestScoped
public class RequestAuctionBean {
    @EJB
    ItiMazadnaItemFacade itemFacade;
    @EJB
    ItiMazadnaAuctionFacade auctionFacade;
    @EJB
    ItiMazadnaAuctionitemFacade auctionitemFacade;
    @EJB
    ItiMazadnaUserFacade userFacade;

    ItiMazadnaAuction mazadnaAuction;
    List<ItiMazadnaItem> items;
    List<ItiMazadnaUser> suppliers;
    public List<String> choosedItems;
    public String choosedSupplier;

    public RequestAuctionBean() {
        mazadnaAuction = new ItiMazadnaAuction();
        mazadnaAuction.setRecid(0L);
    }

    @PostConstruct
    public void update() {
        items = itemFacade.findAll();
        suppliers = userFacade.getAllSuppliers();
        choosedItems = new ArrayList<>();
    }

    public String addAuction() {
        String nextPage = "addAuction";
        if(isEndDateAfterStartDate()) {
            mazadnaAuction.setApprove(0L);
            auctionFacade.addAuction(mazadnaAuction);
            ItiMazadnaAuction addedAuction = auctionFacade.getLastAuction();
            Long supplierId = new Long(choosedSupplier);
            ItiMazadnaUser supplier = userFacade.find(supplierId);
            for (int count = 0; count < choosedItems.size(); count++) {
                ItiMazadnaAuctionitem auctionitem = new ItiMazadnaAuctionitem();
                auctionitem.setItiMazadnaAuction(addedAuction);
                Long itemId = new Long(choosedItems.get(count));
                ItiMazadnaItem foundItem = itemFacade.find(itemId);
                foundItem.setSupplierid(supplier);
                itemFacade.edit(foundItem);
                auctionitem.setItiMazadnaItem(foundItem);

                ItiMazadnaAuctionitemPK auctionitemPK = new ItiMazadnaAuctionitemPK();
                auctionitemPK.setAuctionid(addedAuction.getRecid());
                auctionitemPK.setItemid(foundItem.getRecid());

                auctionitem.setItiMazadnaAuctionitemPK(auctionitemPK);
                auctionitemFacade.create(auctionitem);
                nextPage= "index";
            }
        }
        return nextPage;
    }

    public boolean isEndDateAfterStartDate()
    {
        boolean isValid = true;
        if(mazadnaAuction.getAuctionEnd().before(mazadnaAuction.getAuctionStart())){
            isValid = false;
        }
        return isValid;
    }

    public ItiMazadnaAuction getMazadnaAuction() {
        return mazadnaAuction;
    }

    public void setMazadnaAuction(ItiMazadnaAuction mazadnaAuction) {
        this.mazadnaAuction = mazadnaAuction;
    }

    public List<String> getChoosedItems() {
        return choosedItems;
    }

    public void setChoosedItems(List<String> choosedItems) {
        this.choosedItems = choosedItems;
    }

    public List<ItiMazadnaItem> getItems() {
        return items;
    }

    public void setItems(List<ItiMazadnaItem> items) {
        this.items = items;
    }

    public List<ItiMazadnaUser> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<ItiMazadnaUser> suppliers) {
        this.suppliers = suppliers;
    }

    public String getChoosedSupplier() {
        return choosedSupplier;
    }

    public void setChoosedSupplier(String choosedSuppliers) {
        this.choosedSupplier = choosedSuppliers;
    }

}
