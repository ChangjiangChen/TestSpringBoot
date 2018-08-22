package com.example.demo;

import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("1","2");
        System.out.println(json.size());
    }
}
