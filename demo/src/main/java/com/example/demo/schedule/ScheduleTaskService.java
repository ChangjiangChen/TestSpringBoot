package com.example.demo.schedule;

import com.example.demo.condition.example2.CrawlService;
import org.apache.tomcat.util.http.FastHttpDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleTaskService {

    public static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000L)
    public void consolePrintCurrentTime() {
        System.out.println("fixedRate = 5000L   =>" + format.format(new Date()));
    }

}
