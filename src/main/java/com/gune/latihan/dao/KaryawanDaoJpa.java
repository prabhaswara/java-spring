/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.dao;

import com.gune.latihan.domain.Karyawan;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bni
 */
@Repository
public class KaryawanDaoJpa  extends JpaDAO  implements KaryawanDao{
    public List<Karyawan> selectKaryawan(String searchKey,String searchValue, int startIndex, int maxResult){
        String sql ="SELECT x FROM Karyawan x ";
        
        if(searchKey!=null){
            sql+=" where x."+searchKey+" like '%"+searchValue+"%'";
        }
        Query query = getEntityManager().createQuery(sql);      
       
        if(startIndex!=-1)
        {
            query.setFirstResult(startIndex);
            query.setMaxResults(maxResult);
        }
        
        List<Karyawan> results = null;

        results = query.getResultList();

        return results;
    }
    
    public int countKaryawan(String searchKey,String searchValue, int startIndex, int maxResult){
        String sql ="SELECT count(*) FROM Karyawan x ";
        
        if(searchKey!=null){
            sql+=" where x."+searchKey+" like '%"+searchValue+"%'";
        }
        
        Query query = getEntityManager().createQuery(sql);      
      //  query.setParameter(searchKey, "%"+searchValue+"%");
        int result = ((Long) query.getSingleResult()).intValue();
        return result;      
    }
}
