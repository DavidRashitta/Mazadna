/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.inter;

import mazadna.dal.entities.ItiMazadnaBidderitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author szmoh
 */
@Local
public interface ItiMazadnaBidderitemFacadeLocal {

    void create(ItiMazadnaBidderitem itiMazadnaBidderitem);

    void edit(ItiMazadnaBidderitem itiMazadnaBidderitem);

    void remove(ItiMazadnaBidderitem itiMazadnaBidderitem);

    ItiMazadnaBidderitem find(Object id);

    List<ItiMazadnaBidderitem> findAll();

    List<ItiMazadnaBidderitem> findRange(int[] range);

    int count();
    
}
