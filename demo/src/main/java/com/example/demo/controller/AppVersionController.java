package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.AppVersionInfoService;
import com.example.demo.service.serviceImpl.AppVersionInfoServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/app")
public class AppVersionController {

    @Autowired
    AppVersionInfoService appVersionInfoService;

    @ApiOperation(value="app版本信息", notes="获取app安卓和IOS最新版本信息")
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Object getAppVersion() {
        return appVersionInfoService.getAppVersion();
    }

}
