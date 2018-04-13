package view.controller.managedbean;

import mazadna.dal.entities.ItiMazadnaAuction;
import mazadna.dal.entities.ItiMazadnaUser;
import mazadna.dao.ItiMazadnaAuctionFacade;
import mazadna.dao.ItiMazadnaUserFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "indexBean")
@RequestScoped
public class IndexBean {

    @EJB
    ItiMazadnaAuctionFacade auctionFacade;

    List<ItiMazadnaAuction> auctions;

    public List<ItiMazadnaAuction> getAuctions() {
        auctions = auctionFacade.findAll();
        return auctions;
    }
}
