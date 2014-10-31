/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.model;
import com.gune.latihan.domain.Karyawan;

/**
 *
 * @author Bni
 */

public class KaryawanMdl {

    private String npp;    
    private String nama;
    private String alamat;
    private String kota;
    private String kabupaten;
    private String propinsi;

    public Karyawan toDomain(){
        Karyawan karyawan=new Karyawan();
        karyawan.setAlamat(this.getAlamat());
        karyawan.setKabupaten(this.getKabupaten());
        karyawan.setKota(this.getKota());
        karyawan.setNama(this.getNama());
        karyawan.setNpp(this.getNpp());
        karyawan.setPropinsi(this.getPropinsi());
        
        return karyawan;
    }
    public KaryawanMdl fromDomain(Karyawan karyawan){
     
        this.setAlamat(karyawan.getAlamat());
        this.setKabupaten(karyawan.getKabupaten());
        this.setKota(karyawan.getKota());
        this.setNama(karyawan.getNama());
        this.setNpp(karyawan.getNpp());
        this.setPropinsi(karyawan.getPropinsi());        
        return this;
    }
    
    public String getNpp() {
        return npp;
    }

    public void setNpp(String npp) {
        this.npp = npp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(String propinsi) {
        this.propinsi = propinsi;
    }
    
    
}

