/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;

import mazadna.dal.entities.*;
import mazadna.dao.ItiMazadnaAuctionFacade;
import mazadna.dao.ItiMazadnaAuctionitemFacade;
import mazadna.dao.ItiMazadnaItemFacade;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author Eman-PC
 */
@ManagedBean(name = "addAuctionBean")
@RequestScoped
public class AddAuctionBean {

    @EJB
    ItiMazadnaItemFacade itemFacade;
    @EJB
    ItiMazadnaAuctionFacade auctionFacade;
    @EJB
    ItiMazadnaAuctionitemFacade auctionitemFacade;

    ItiMazadnaAuction mazadnaAuction;
    List<ItiMazadnaItem> items;
    public List<String> choosedItems;

    public AddAuctionBean() {
        mazadnaAuction = new ItiMazadnaAuction();
        mazadnaAuction.setRecid(0L);
    }

    @PostConstruct
    public void update() {
        items = itemFacade.findAll();
        choosedItems = new ArrayList<>();
    }

    public String addAuction() {
        String nextPage = "addAuction";
        if(isEndDateAfterStartDate()) {
            mazadnaAuction.setApprove(1L);
            auctionFacade.addAuction(mazadnaAuction);
            ItiMazadnaAuction addedAuction = auctionFacade.getLastAuction();

            for (int count = 0; count < choosedItems.size(); count++) {
                ItiMazadnaAuctionitem auctionitem = new ItiMazadnaAuctionitem();
                auctionitem.setItiMazadnaAuction(addedAuction);
                Long num = new Long(choosedItems.get(count));
                ItiMazadnaItem foundItem = itemFacade.find(num);
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

}
