package com.example.demo.condition.example2;

public abstract class AbstractCrawlServiceImpl implements CrawlService{
    protected String createSQL(String tableName){
        String createTableSQL = "CREATE TABLE `"+tableName+"` (\n" +
                "  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `batch_id` tinyint(3) unsigned NOT NULL,\n" +
                "  `url` varchar(200) NOT NULL,\n" +
                "  `category_id` tinyint(3) unsigned NOT NULL COMMENT 'elasticsearch需要字段',\n" +
                "  `category` varchar(10) NOT NULL COMMENT 'elasticseach需求字段，映射为category_name',\n" +
                "  `crawled_title` varchar(200) NOT NULL COMMENT '爬取的新闻标题（纯文本）',\n" +
                "  `crawled_date` char(10) NOT NULL COMMENT '爬取的新闻时间（纯文本格式：yyyy-MM-dd）',\n" +
                "  `crawled_content` char(1) NOT NULL DEFAULT '无' COMMENT 'elasticsearch需求字段，无内容',\n" +
                "  `crawled_content_html` text NOT NULL COMMENT '爬取的新闻内容（带html标签）',\n" +
                "  `area` char(6) NOT NULL COMMENT 'elasticsearch需求字段，此处映射为area_id',\n" +
                "  `is_filtered` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '0表示未过滤，1表示已过滤',\n" +
                "  `gmt_create` datetime NOT NULL,\n" +
                "  `gmt_modified` datetime NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        return createTableSQL;
    }
}
