/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.util;
import java.util.List;
/**
 *
 * @author Bni
 */


public class Page<T> {

    private int page;
    private int max;
    private int total;
    private List<T> rows;

    public Page() {
    }

    public Page(List<T> rows, int page, int max, int total) {
        this.rows = rows;
        this.page = page;
        this.max = max;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}