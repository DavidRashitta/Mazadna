/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;

import mazadna.dal.entities.*;
import mazadna.dal.factory.EntityFactory;
import mazadna.dao.ItiMazadnaAuctionFacade;
import mazadna.dao.ItiMazadnaAuctionitemFacade;
import mazadna.dao.ItiMazadnaItemFacade;

import java.math.BigDecimal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Eman-PC
 */
@ManagedBean(name = "addAuctionBean")
@RequestScoped
public class AddAuctionBean {

    ItiMazadnaItemFacade itemFacade = EntityFactory.getItemFacade();
    ItiMazadnaAuctionFacade auctionFacade = EntityFactory.getAuctionFacade();
    ItiMazadnaAuctionitemFacade auctionitemFacade = EntityFactory.getAuctionitemFacade();
    ItiMazadnaAuction mazadnaAuction;
    List<ItiMazadnaItem> items;
    public BigDecimal[] choosedItems;

    /**
     * Creates a new instance of AddAuctionBean
     */
    public AddAuctionBean() {
        mazadnaAuction = new ItiMazadnaAuction();
        items = itemFacade.findAll();
    }

    public String addAuction() {
        mazadnaAuction.setApprove(0L);
        auctionFacade.create(mazadnaAuction);
        BigDecimal auctionId = new BigDecimal(123);
        for (int count = 0; count < choosedItems.length; count++) {
            ItiMazadnaAuctionitem auctionitem = new ItiMazadnaAuctionitem();
            auctionitem.setItiMazadnaAuction(mazadnaAuction);
        }

        return null;
    }

    public ItiMazadnaAuction getMazadnaAuction() {
        return mazadnaAuction;
    }

    public void setMazadnaAuction(ItiMazadnaAuction mazadnaAuction) {
        this.mazadnaAuction = mazadnaAuction;
    }

    public BigDecimal[] getChoosedItems() {
        return choosedItems;
    }

    public void setChoosedItems(BigDecimal[] choosedItems) {
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

}
