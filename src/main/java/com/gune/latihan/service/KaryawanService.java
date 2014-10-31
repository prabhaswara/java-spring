/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.service;

import com.gune.latihan.domain.Karyawan;
import java.util.List;

/**
 *
 * @author Bni
 */
public interface KaryawanService {
    public void createKaryawan(Karyawan karyawan) throws Exception;
    public List<Karyawan> selectKaryawan(String searchKey,String searchValue, int startIndex, int maxResult);
    public int countKaryawan(String searchKey,String searchValue, int startIndex, int maxResult);
}
