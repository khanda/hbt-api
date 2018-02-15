package com.hbt.gd.controller;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.service.KhoiService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/khoi", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class KhoiController {
    private final static Logger logger = Logger.getLogger(CoreUserController.class);
    @Autowired
    KhoiService khoiService;

    @PostMapping("/getList")
    public Iterable<KhoiDto> getList() {
        return khoiService.getList();
    }

}