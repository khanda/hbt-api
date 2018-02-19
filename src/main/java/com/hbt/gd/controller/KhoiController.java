package com.hbt.gd.controller;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Khoi;
import com.hbt.gd.exception.HBTException;
import com.hbt.gd.service.KhoiService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public KhoiDto save(@RequestBody Khoi khoi) throws HBTException {
        return khoiService.save(khoi);
    }

    @PostMapping("/deleteLeader")
    public boolean sdeleteLeader(@RequestBody Khoi khoi) throws HBTException {
        return khoiService.deleteLeader(khoi);
    }
}