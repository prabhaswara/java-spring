/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mohamad Guntur Nugraha
 * @version 1.0
 * @since 2013/05/12
 */
public class PageUtil {

    public static final String PARAMETER_DEFAULT = "default";
    public static final int ROW_LIMIT_PER_PAGE = 10;
    public static final int CATEGORY_ROW = 1;

    public static Page getListPage(int page, int max, List list) {
        final int startIdx = (page - 1) * max;
        final int endIdx = Math.min(startIdx + max, list.size());
        return new Page(list.subList(startIdx, endIdx), page, max, list.size());
    }

    public static Page getListPage(int page, int max, List list, int total) {
        if (total <= 0) {
            page = 1;
        }
        return new Page(list, page, max, total);
    }
    
    public static Map createRowDetail(Object... values) {
        Map data = new HashMap();
        int column = 0;
        for (Object value : values) {
            if (value != null) {
                data.put(String.valueOf(column), value);
            }
            column++;
        }
        //data.put("fieldName", name);
        return data;
    }
}