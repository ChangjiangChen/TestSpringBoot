package com.example.demo.service.serviceImpl;

import com.example.demo.dao.AppVersionInfoMapper;
import com.example.demo.entity.AppVersionInfoEntity;
import com.example.demo.service.AppVersionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionInfoServiceImpl implements AppVersionInfoService {
    @Autowired
    AppVersionInfoMapper appVersionInfoMapper;

    @Override
    public List<AppVersionInfoEntity> getAppVersion() {
        return appVersionInfoMapper.listAppVersionInfoEntity();
    }
}
