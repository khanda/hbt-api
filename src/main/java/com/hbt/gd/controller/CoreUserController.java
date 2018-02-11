package com.hbt.gd.controller;

import com.hbt.gd.dto.CoreUserDto;
import com.hbt.gd.entity.CoreUser;
import com.hbt.gd.entity.UserRole;
import com.hbt.gd.enums.EnumStatus;
import com.hbt.gd.helper.MessageConstant;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.helper.PagingParameter;
import com.hbt.gd.helper.SimpleResponse;
import com.hbt.gd.service.CoreUserService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class CoreUserController {
    private final static Logger logger = Logger.getLogger(CoreUserController.class);
    @Autowired
    private CoreUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CoreUserController() {

    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody CoreUserDto coreUserDto) {
        ModelMapper modelMapper = new ModelMapper();
        CoreUser coreUser = modelMapper.map(coreUserDto, CoreUser.class);
        coreUser.setPassword(bCryptPasswordEncoder.encode(coreUser.getPassword()));
        userService.save(coreUser);
    }

    @PostMapping("/save")
    public @ResponseBody
    SimpleResponse saveAccount(@RequestBody CoreUserDto coreUserDto) {
        SimpleResponse response = new SimpleResponse();

        ModelMapper modelMapper = new ModelMapper();
        CoreUser coreUser = modelMapper.map(coreUserDto, CoreUser.class);
        coreUser.setPassword(bCryptPasswordEncoder.encode(coreUser.getPassword()));

        boolean result = userService.save(coreUser);

        if (result) {
            response.setStatus(EnumStatus.SUCCESS);
            response.setMessage(MessageConstant.SUCCESS);
        } else {
            response.setStatus(EnumStatus.ERROR);
            response.setMessage(MessageConstant.ERROR);
        }
        return response;
    }

    @PostMapping("/get")
    public @ResponseBody
    CoreUserDto getAccount(@RequestBody Long id) {
        logger.info("getAccount: id = " + id);

        CoreUser coreUser = userService.getCoreUser(id);
        coreUser.setPassword(null);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(coreUser, CoreUserDto.class);
    }

    @PostMapping("/getList")
    public @ResponseBody
    PagingData<CoreUser> getListAccount(@RequestBody PagingParameter pagingParameter) {
        PagingData<CoreUser> pagingData = new PagingData<>();
        Integer page = pagingParameter.getPage();
        Integer itemPerPage = pagingParameter.getPageSize();

        logger.info("getListAccount: page = " + page + ", max = " + itemPerPage);

        List<CoreUser> coreUsers = userService.getListCoreUser(page, itemPerPage);

        Long count = userService.getListCoreUserCount(page, itemPerPage);

        pagingData.setData(coreUsers);
        pagingData.setPage(page);
        pagingData.setPageSize(itemPerPage);
        pagingData.setTotal(count);

        return pagingData;
    }

    @PostMapping("/getListRoleAccount")
    public @ResponseBody
    List<UserRole> getListRoleAccount() {
        return userService.getAccountRoles();
    }

    @PostMapping("/delete")
    public @ResponseBody
    boolean deleteAccount(@RequestBody Long id) {
        return userService.delete(id);
    }

} 
