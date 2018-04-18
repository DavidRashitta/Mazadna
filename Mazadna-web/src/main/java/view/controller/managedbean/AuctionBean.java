/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;

import mazadna.dal.entities.*;
import mazadna.dao.ItiMazadnaBidderitemFacade;
import mazadna.dao.ItiMazadnaItemFacade;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * @author Eman-PC
 */
@ManagedBean(name = "auctionBean")
@SessionScoped
public class AuctionBean {

    @ManagedProperty(value = "#{user}")
    UserBean userBean;

    @EJB
    private ItiMazadnaBidderitemFacade itiMazadnaBidderitemFacade;
    @EJB
    private ItiMazadnaItemFacade itiMazadnaItemFacade;

    private List<ItiMazadnaItem> items;
    private ItiMazadnaAuction mazadnaAuction;
    private DataModel<ItiMazadnaItem> model;
    private ItiMazadnaItem item;

    public AuctionBean() {
        model = new ListDataModel<>();
    }

    public String placeBid() {
        ItiMazadnaUser currentUser = userBean.getCurrentUser();
        ItiMazadnaItem item = model.getRowData();

        ItiMazadnaBidderitem bidderitem = new ItiMazadnaBidderitem();

        bidderitem.setBidamount(item.getPlaceBidAmount());
        ItiMazadnaBidderitemPK bidderitemPK = new ItiMazadnaBidderitemPK();
        bidderitemPK.setBidderid(currentUser.getRecid());
        bidderitemPK.setItemid(item.getRecid());
        bidderitem.setItiMazadnaBidderitemPK(bidderitemPK);

        itiMazadnaBidderitemFacade.edit(bidderitem);

        item.setName("updated");
        return "";
    }


    public void updateModelData() {

        items = itiMazadnaItemFacade.getItemsOfSpecificAuction(mazadnaAuction.getRecid());
        model.setWrappedData(items);
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public ItiMazadnaAuction getMazadnaAuction() {
        return mazadnaAuction;
    }

    public void setMazadnaAuction(ItiMazadnaAuction mazadnaAuction) {
        this.mazadnaAuction = mazadnaAuction;
        updateModelData();
    }

    public DataModel<ItiMazadnaItem> getModel() {
        return model;
    }

    public void setModel(DataModel<ItiMazadnaItem> model) {
        this.model = model;
    }

    public List<ItiMazadnaItem> getItems() {
        return items;
    }

    public void setItems(List<ItiMazadnaItem> items) {
        this.items = items;
    }
}