/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gune.latihan.controller;

import com.gune.latihan.domain.Karyawan;
import com.gune.latihan.model.KaryawanMdl;
import com.gune.latihan.service.KaryawanService;
import com.gune.latihan.util.Page;
import com.gune.latihan.util.PageUtil;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Bni
 */
@Controller
public class KaryawanController {

    @Autowired
    KaryawanService karyawanService;
    private final static Logger log = Logger.getLogger(KaryawanController.class.getName());

    @RequestMapping(value = URIConstants.KARYAWAN_LIST, method = RequestMethod.GET)
    public String pageList(ModelMap model) {
        return URIConstants.KARYAWAN_LIST;
    }

    @RequestMapping(value = URIConstants.KARYAWAN_LISTJSON, method = RequestMethod.GET)
    public @ResponseBody
    Page jsonList(ModelMap model,
            @RequestParam(value = "searchBy", required = false) String searchBy,
            @RequestParam(value = "searchVal", required = false) String searchVal,
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String row,
            @RequestParam(value = "sidx", required = false) String sidx,
            @RequestParam(value = "sord", required = false) String sord
    
    ) {
        
       
        
     
     
        int pageSelected = (page == null ? 0 : Integer.parseInt(page));

        int rowLimit=Integer.parseInt(((row==null)?"10":row));        
        int startIndex = pageSelected < 2 ? 0 : (pageSelected - 1) * rowLimit;       

        Page viewPage = new Page();

        List<Karyawan> listKaryawan = karyawanService.selectKaryawan(searchBy, searchVal, startIndex, rowLimit);
        int countList = karyawanService.countKaryawan(searchBy, searchVal, startIndex, rowLimit);
        viewPage = PageUtil.getListPage(pageSelected, rowLimit, listKaryawan, countList);
        
        log.info("rowLimit:"+rowLimit);
        log.info("totalRow:"+countList);

        return viewPage;

    }

    @RequestMapping(value = URIConstants.KARYAWAN_ADD, method = RequestMethod.GET)
    public String pageAdd(ModelMap model) {
        KaryawanMdl karyawanMdl = new KaryawanMdl();
        model.put("karyawanMdl", karyawanMdl);
        return URIConstants.KARYAWAN_ADD;
    }

    @RequestMapping(value = URIConstants.KARYAWAN_ADD, method = RequestMethod.POST)
    public String add(ModelMap model, @ModelAttribute("karyawanMdl") KaryawanMdl karyawanMdl) {
        try {
            karyawanService.createKaryawan(karyawanMdl.toDomain());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.put("karyawanMdl", karyawanMdl);
        return URIConstants.KARYAWAN_ADD;
    }

    @RequestMapping(value = URIConstants.KARYAWAN_EDIT, method = RequestMethod.GET)
    public String pageEdit(ModelMap model) {
        return URIConstants.KARYAWAN_EDIT;
    }

   
}
