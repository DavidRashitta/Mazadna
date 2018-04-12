/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.inter;

import mazadna.dal.entities.ItiMazadnaAuctionitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author szmoh
 */
@Local
public interface ItiMazadnaAuctionitemFacadeLocal {

    void create(ItiMazadnaAuctionitem itiMazadnaAuctionitem);

    void edit(ItiMazadnaAuctionitem itiMazadnaAuctionitem);

    void remove(ItiMazadnaAuctionitem itiMazadnaAuctionitem);

    ItiMazadnaAuctionitem find(Object id);

    List<ItiMazadnaAuctionitem> findAll();

    List<ItiMazadnaAuctionitem> findRange(int[] range);

    int count();
    
}
