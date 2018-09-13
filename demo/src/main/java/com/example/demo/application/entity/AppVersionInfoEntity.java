package com.example.demo.application.entity;

import lombok.Data;
import java.util.Date;

@Data
public class AppVersionInfoEntity {
    private int field_id;
    private Date gmt_create;
    private Date gmt_modified;
    private String new_version;
    private String min_version;
    private String download_url;
    private String update_description;
    private int force_update;
    private String device_system;
    private Date public_time;
}
