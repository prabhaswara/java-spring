/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.service;
/*
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
*/
import com.gune.latihan.dao.KaryawanDao;
import com.gune.latihan.domain.Karyawan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bni
 */
@Service
public class KaryawanServiceImpl implements KaryawanService{

    @Autowired
    private KaryawanDao karyawanDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {java.lang.Exception.class})
    public void createKaryawan(Karyawan karyawan) throws Exception {
        karyawanDao.persist(karyawan);
    }
    
    @Override
    public List<Karyawan> selectKaryawan(String searchKey,String searchValue, int startIndex, int maxResult){
        
        return karyawanDao.selectKaryawan(searchKey, searchValue, startIndex, maxResult);
    }
    
    @Override
    public int countKaryawan(String searchKey,String searchValue, int startIndex, int maxResult){
        return karyawanDao.countKaryawan(searchKey, searchValue, startIndex, maxResult);
    }
    
}
