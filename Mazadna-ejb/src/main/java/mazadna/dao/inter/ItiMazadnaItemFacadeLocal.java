/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.inter;

import mazadna.dal.entities.ItiMazadnaItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author szmoh
 */
@Local
public interface ItiMazadnaItemFacadeLocal {

    void create(ItiMazadnaItem itiMazadnaItem);

    void edit(ItiMazadnaItem itiMazadnaItem);

    void remove(ItiMazadnaItem itiMazadnaItem);

    ItiMazadnaItem find(Object id);

    List<ItiMazadnaItem> findAll();

    List<ItiMazadnaItem> findRange(int[] range);

    int count();
    
}
