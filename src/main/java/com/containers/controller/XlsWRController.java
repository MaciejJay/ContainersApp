package com.containers.controller;

import com.containers.utilities.xls.XlsService;
import org.springframework.stereotype.Controller;

@Controller
public class XlsWRController {

    private XlsService xlsService;

    public XlsWRController(XlsService xlsService) {
        this.xlsService = xlsService;
    }


}
