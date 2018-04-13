package mazadna.dal.factory;

import mazadna.dao.impl.*;

public class EntityFactory {
    private static ItiMazadnaItemFacade itemFacade = null;
    private static ItiMazadnaAuctionFacade auctionFacade = null;
    private static ItiMazadnaAuctionitemFacade auctionitemFacade = null;
    private static ItiMazadnaBidderitemFacade bidderitemFacade = null;
    private static ItiMazadnaUserFacade userFacade = null;

    public static ItiMazadnaItemFacade getItemFacade() {
        if(itemFacade==null)
            itemFacade = new ItiMazadnaItemFacade();
        return itemFacade;
    }

    public static ItiMazadnaAuctionFacade getAuctionFacade() {
        if(auctionFacade==null)
            auctionFacade = new ItiMazadnaAuctionFacade();
        return auctionFacade;
    }

    public static ItiMazadnaAuctionitemFacade getAuctionitemFacade() {
        if(auctionitemFacade==null)
            auctionitemFacade = new ItiMazadnaAuctionitemFacade();
        return auctionitemFacade;
    }

    public static ItiMazadnaBidderitemFacade getBidderitemFacade() {
        if(bidderitemFacade==null)
            bidderitemFacade = new ItiMazadnaBidderitemFacade();
        return bidderitemFacade;
    }

    public static ItiMazadnaUserFacade getUserFacade() {
        if(userFacade==null)
            userFacade = new ItiMazadnaUserFacade();
        return userFacade;
    }
}
