package com.example.demo.application.service.serviceImpl;

import com.example.demo.application.dao.AppVersionInfoMapper;
import com.example.demo.application.entity.AppVersionInfoEntity;
import com.example.demo.application.service.AppVersionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
@Transactional
@Service
public class AppVersionInfoServiceImpl implements AppVersionInfoService {
    @Autowired
    AppVersionInfoMapper appVersionInfoMapper;

    @Override
    public List<AppVersionInfoEntity> getAppVersion() {
        return appVersionInfoMapper.listAppVersionInfoEntity();
    }

    @Override
    public int addVersionInfo(AppVersionInfoEntity appVersionInfoEntity) {
        //测试事务回滚（注意要RuntimeException被aop扫描到之后才能触发回滚）
        //方法1：try.catch中在异常处理里抛出 throw new RuntimeException();
        //方法2：try.catch中在异常处理里抛出 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        AppVersionInfoEntity appVersionInfoEntity1 = new AppVersionInfoEntity();
        appVersionInfoEntity1.setDevice_system("TEST");
        appVersionInfoEntity1.setDownload_url("y");
        appVersionInfoEntity1.setForce_update(1);
        appVersionInfoEntity1.setGmt_create(new Date());
        appVersionInfoEntity1.setGmt_modified(new Date());
        appVersionInfoEntity1.setMin_version("123");
        appVersionInfoEntity1.setNew_version("23");
        appVersionInfoEntity1.setPublic_time(new Date());
        appVersionInfoEntity1.setUpdate_description("测试");
        appVersionInfoMapper.addVersionInfo(appVersionInfoEntity1);
        System.out.println(appVersionInfoMapper.listAppVersionInfoEntity());
        try {
            System.out.println(1/0);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return appVersionInfoMapper.addVersionInfo(appVersionInfoEntity);
    }
}
