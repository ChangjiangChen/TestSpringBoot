package com.example.demo.application.service;

import com.example.demo.application.entity.AppVersionInfoEntity;

import java.util.List;

public interface AppVersionInfoService {
    public List<AppVersionInfoEntity> getAppVersion();

    public int addVersionInfo(AppVersionInfoEntity appVersionInfoEntity);

}
