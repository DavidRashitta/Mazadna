/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.inter;

import mazadna.dal.entities.ItiMazadnaAuction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author szmoh
 */
@Local
public interface ItiMazadnaAuctionFacadeLocal {

    void create(ItiMazadnaAuction itiMazadnaAuction);

    void edit(ItiMazadnaAuction itiMazadnaAuction);

    void remove(ItiMazadnaAuction itiMazadnaAuction);

    ItiMazadnaAuction find(Object id);

    List<ItiMazadnaAuction> findAll();

    List<ItiMazadnaAuction> findRange(int[] range);

    int count();
    
}
