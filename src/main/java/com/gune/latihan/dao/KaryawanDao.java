/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.dao;

import com.gune.latihan.domain.Karyawan;
import java.util.List;

/**
 *
 * @author Bni
 */
public interface KaryawanDao extends DbGenericDAO{
    public List<Karyawan> selectKaryawan(String searchKey,String searchValue, int startIndex, int maxResult);
    public int countKaryawan(String searchKey,String searchValue, int startIndex, int maxResult);
}
