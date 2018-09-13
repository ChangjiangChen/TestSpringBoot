package com.example.demo;

import com.example.demo.condition.example2.CrawlService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启组建扫描和自动配置
//@MapperScan(basePackages = "com.example.demo.dao")
@SpringBootApplication(scanBasePackages = "com.example.demo.*", exclude = ErrorMvcAutoConfiguration.class)
@EnableTransactionManagement
public class DemoApplication {

    public static ConfigurableApplicationContext cac;

    public static void main(String[] args) {
        System.setProperty("crawlMethod","original");
        cac = SpringApplication.run(DemoApplication.class, args);
        System.out.println("--------------------启动成功--------------------");
        /**
         * 其它类中的static变量也可以通过这种方式进行方法调用
         * @Autowired
         * private static CrawlService crawlService;
         * 会报空指针，可以用此方法解决
         */
        cac.getBean(CrawlService.class).crawl();
    }
}

