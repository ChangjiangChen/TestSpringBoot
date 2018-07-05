package com.example.demo;

import com.example.demo.dao.AppVersionInfoMapper;
import com.example.demo.entity.AppVersionInfoEntity;
import com.example.demo.service.AppVersionInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    AppVersionInfoMapper appVersionInfoMapper;
    @Autowired
    AppVersionInfoService appVersionInfoService;

    //     如果想要关闭回滚，设置@Rollback(false)
//    @Rollback(false)
//    @Transactional
    @Test
    public void testServiceRollback() {
        appVersionInfoService.addVersionInfo(null);
    }

    //     开启回滚加@Transactional；如果想要关闭回滚，设置@Rollback(false)
//    @Rollback(false)
    @Transactional
    @Test
    public void testRollbackAnnotation() {
        AppVersionInfoEntity appVersionInfoEntity = new AppVersionInfoEntity();
        appVersionInfoEntity.setDevice_system("TEST");
        appVersionInfoEntity.setDownload_url("y");
        appVersionInfoEntity.setForce_update(1);
        appVersionInfoEntity.setGmt_create(new Date());
        appVersionInfoEntity.setGmt_modified(new Date());
        appVersionInfoEntity.setMin_version("123");
        appVersionInfoEntity.setNew_version("23");
        appVersionInfoEntity.setPublic_time(new Date());
        appVersionInfoEntity.setUpdate_description("测试");
        System.out.println(appVersionInfoMapper.addVersionInfo(appVersionInfoEntity));
    }

}
