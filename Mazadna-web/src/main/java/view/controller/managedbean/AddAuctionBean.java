/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaAuctionitem;
import mazadna.dal.entities.ItiMazadnaAuctionitemPK;
import mazadna.dal.entities.ItiMazadnaItem;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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

    Date currentDate = new Date();

    ItiMazadnaAuction mazadnaAuction;
    List<ItiMazadnaItem> items;
    public List<String> choosedItems;

    /**
     * Creates a new instance of AddAuctionBean
     */
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
        mazadnaAuction.setApprove(0L);
        auctionFacade.addAuction(mazadnaAuction);
        ItiMazadnaAuction addedAuction = auctionFacade.getLastAuction();
        //int count = 0;
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
            // count++;
        }
        return null;
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

    public ItiMazadnaItemFacade getItemFacade() {
        return itemFacade;
    }

    public void setItemFacade(ItiMazadnaItemFacade itemFacade) {
        this.itemFacade = itemFacade;
    }

    public List<ItiMazadnaItem> getItems() {
        return items;
    }

    public void setItems(List<ItiMazadnaItem> items) {
        this.items = items;
    }

    public ItiMazadnaAuctionFacade getAuctionFacade() {
        return auctionFacade;
    }

    public void setAuctionFacade(ItiMazadnaAuctionFacade auctionFacade) {
        this.auctionFacade = auctionFacade;
    }

    public ItiMazadnaAuctionitemFacade getAuctionitemFacade() {
        return auctionitemFacade;
    }

    public void setAuctionitemFacade(ItiMazadnaAuctionitemFacade auctionitemFacade) {
        this.auctionitemFacade = auctionitemFacade;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

}
