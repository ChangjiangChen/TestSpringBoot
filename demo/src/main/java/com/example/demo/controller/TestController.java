package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value="更新信息", notes="根据url的id来指定更新图书信息")
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public Object getTestJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "value");
        jsonObject.put("键","值");
        log.info("=="+jsonObject+"==");
        return jsonObject;
    }
}
