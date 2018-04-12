/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dao.inter;

import mazadna.dal.entities.ItiMazadnaUser;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author szmoh
 */
@Local
public interface ItiMazadnaUserFacadeLocal {

    void create(ItiMazadnaUser itiMazadnaUser);

    void edit(ItiMazadnaUser itiMazadnaUser);

    void remove(ItiMazadnaUser itiMazadnaUser);

    ItiMazadnaUser find(Object id);

    List<ItiMazadnaUser> findAll();

    List<ItiMazadnaUser> findRange(int[] range);

    int count();
    
}
