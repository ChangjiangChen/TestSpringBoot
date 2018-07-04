package com.example.demo.dao;

import com.example.demo.entity.AppVersionInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AppVersionInfoMapper {
    List<AppVersionInfoEntity> listAppVersionInfoEntity();
}
