package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dao.ItiMazadnaAuctionFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "indexBean")
@RequestScoped
public class IndexBean {

    @EJB
    ItiMazadnaAuctionFacade auctionFacade;

    @ManagedProperty(value = "#{auctionBean}")
    private AuctionBean auctionBean;

    List<ItiMazadnaAuction> auctions;


    public AuctionBean getAuctionBean() {
        return auctionBean;
    }

    public void setAuctionBean(AuctionBean auctionBean) {
        this.auctionBean = auctionBean;
    }

    public List<ItiMazadnaAuction> getAuctions() {
        auctions = auctionFacade.findAll();
        return auctions;
    }

    public String navigate(ItiMazadnaAuction auction) {
        this.auctionBean.setMazadnaAuction(auction);
        return "single";
    }
}
