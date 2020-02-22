package com.containers.controller;

import com.containers.utilities.xssf.XlsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class XlsWRController {

    private XlsService xlsService;

    public XlsWRController(XlsService xlsService) {
        this.xlsService = xlsService;
    }



//      Example how to download file
//    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
//    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
//        try {
//            // get your file as InputStream
//            InputStream is = ...;
//            // copy it to response's OutputStream
//            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
//            response.flushBuffer();
//        } catch (IOException ex) {
//            log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
//            throw new RuntimeException("IOError writing file to output stream");
//        }

}
