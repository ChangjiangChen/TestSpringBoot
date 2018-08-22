package com.example.demo;

import com.example.demo.async.TestAsyncService;
import com.example.demo.condition.example1.ListService;
import com.example.demo.dao.AppVersionInfoMapper;
import com.example.demo.entity.AppVersionInfoEntity;
import com.example.demo.service.AppVersionInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    AppVersionInfoMapper appVersionInfoMapper;
    @Autowired
    AppVersionInfoService appVersionInfoService;
    @Autowired
    TestAsyncService testAsyncService;
    @Autowired
    ListService listService;

    //     如果想要关闭回滚，设置@Rollback(false)
//    @Rollback(false)
//    @Transactional
    @Test
    public void testServiceRollback() {
        appVersionInfoService.addVersionInfo(null);
    }

    //    开启回滚加@Transactional；如果想要关闭回滚，设置@Rollback(false)
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

    @Test
    public void testAsyncFunction() throws ExecutionException, InterruptedException {
        testAsyncService.asyncInvokeSimple();
        testAsyncService.asyncInvokeWithParameters("test");
        System.out.println("-------------------");
        for (int i = 0; i < 100; i++) {
            Future<String> future = testAsyncService.asyncReturnFuture(i);
            System.out.println(future.get());
        }
    }

    @Test
    public void testConditionalAnnotation() {
        System.out.println(listService.showListCmd());
    }

}
