/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bni
 */
@Entity
@Table(name = "karyawan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k"),
    @NamedQuery(name = "Karyawan.findByNpp", query = "SELECT k FROM Karyawan k WHERE k.npp = :npp"),
    @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama"),
    @NamedQuery(name = "Karyawan.findByAlamat", query = "SELECT k FROM Karyawan k WHERE k.alamat = :alamat"),
    @NamedQuery(name = "Karyawan.findByKota", query = "SELECT k FROM Karyawan k WHERE k.kota = :kota"),
    @NamedQuery(name = "Karyawan.findByKabupaten", query = "SELECT k FROM Karyawan k WHERE k.kabupaten = :kabupaten"),
    @NamedQuery(name = "Karyawan.findByPropinsi", query = "SELECT k FROM Karyawan k WHERE k.propinsi = :propinsi")})
public class Karyawan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "npp")
    private String npp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kota")
    private String kota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kabupaten")
    private String kabupaten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "propinsi")
    private String propinsi;

    public Karyawan() {
    }

    public Karyawan(String npp) {
        this.npp = npp;
    }

    public Karyawan(String npp, String nama, String alamat, String kota, String kabupaten, String propinsi) {
        this.npp = npp;
        this.nama = nama;
        this.alamat = alamat;
        this.kota = kota;
        this.kabupaten = kabupaten;
        this.propinsi = propinsi;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (npp != null ? npp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.npp == null && other.npp != null) || (this.npp != null && !this.npp.equals(other.npp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gune.latihan.domain.Karyawan[ npp=" + npp + " ]";
    }
    
}
