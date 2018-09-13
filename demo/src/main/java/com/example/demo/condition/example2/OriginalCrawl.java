package com.example.demo.condition.example2;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
@ConditionalOnProperty(name = "crawlMethod",havingValue = "original")
@Service
public class OriginalCrawl extends AbstractCrawlServiceImpl{
    @Override
    public void crawl() {
        System.out.println(this.createSQL("original_crawl_table_info"));
    }
}
