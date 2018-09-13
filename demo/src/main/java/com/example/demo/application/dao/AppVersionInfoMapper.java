package com.example.demo.application.dao;

import com.example.demo.application.entity.AppVersionInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 对应xml中的<mapper namespace="com.example.demo.application.dao.AppVersionInfoMapper">
 */
@Mapper
public interface AppVersionInfoMapper {
    List<AppVersionInfoEntity> listAppVersionInfoEntity();

    int addVersionInfo(AppVersionInfoEntity appVersionInfoEntity);
}
