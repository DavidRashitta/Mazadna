/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;

import mazadna.dal.entities.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

/**
 *
 * @author Eman-PC
 */
@ManagedBean(name = "auction")
@RequestScoped
public class AuctionBean {

    private ItiMazadnaAuction mazadnaAuction;
    private DataModel<ItiMazadnaAuctionitem> model;

    public AuctionBean() {

        mazadnaAuction = new ItiMazadnaAuction();
        mazadnaAuction.setAuctionStart(new Date());
        mazadnaAuction.setAuctionEnd(new Date());
        mazadnaAuction.setRecid(3L);

        ItiMazadnaItem item = new ItiMazadnaItem();
        item.setBidincrement(10L);
        item.setDescription("item1");
        item.setMinprice(100L);
        item.setName("item11");
        item.setRecid(1L);

        ItiMazadnaItem item2 = new ItiMazadnaItem();
        item2.setBidincrement(5L);
        item2.setDescription("item2");
        item2.setMinprice(110L);
        item2.setName("item21");
        item2.setRecid(2L);

        ItiMazadnaAuctionitemPK auctionitemPK = new ItiMazadnaAuctionitemPK();
        auctionitemPK.setAuctionid(mazadnaAuction.getRecid());
        auctionitemPK.setItemid(item.getRecid());

        ItiMazadnaAuctionitem auctionitem = new ItiMazadnaAuctionitem();
        auctionitem.setItiMazadnaAuction(mazadnaAuction);
        auctionitem.setItiMazadnaItem(item);
        auctionitem.setItiMazadnaAuctionitemPK(auctionitemPK);

        ItiMazadnaAuctionitemPK auctionitemPK2 = new ItiMazadnaAuctionitemPK();
        auctionitemPK2.setAuctionid(mazadnaAuction.getRecid());
        auctionitemPK2.setItemid(item2.getRecid());

        ItiMazadnaAuctionitem auctionitem2 = new ItiMazadnaAuctionitem();
        auctionitem2.setItiMazadnaAuction(mazadnaAuction);
        auctionitem2.setItiMazadnaItem(item2);
        auctionitem2.setItiMazadnaAuctionitemPK(auctionitemPK2);

        Set<ItiMazadnaAuctionitem> test = new HashSet<>();
        test.add(auctionitem);
        test.add(auctionitem2);

        mazadnaAuction.setItiMazadnaAuctionitemSet(test);

        updateModelData();
    }

    public String placeBid() {
        ItiMazadnaAuctionitem auctionItem = model.getRowData();
        auctionItem.getItiMazadnaItem().setName("updated");
        updateModelData();
        return null;
    }

    public void updateModelData() {
        Set<ItiMazadnaAuctionitem> auctionItems = mazadnaAuction.getItiMazadnaAuctionitemSet();
        ItiMazadnaAuctionitem[] auctionItemsArray = new ItiMazadnaAuctionitem[auctionItems.size()];
        auctionItems.toArray(auctionItemsArray);
        model = new ArrayDataModel<>(auctionItemsArray);
    }

    public ItiMazadnaAuction getMazadnaAuction() {
        return mazadnaAuction;
    }

    public void setMazadnaAuction(ItiMazadnaAuction mazadnaAuction) {
        this.mazadnaAuction = mazadnaAuction;
    }

    public DataModel<ItiMazadnaAuctionitem> getModel() {
        return model;
    }

    public void setModel(DataModel<ItiMazadnaAuctionitem> model) {
        this.model = model;
    }

}
