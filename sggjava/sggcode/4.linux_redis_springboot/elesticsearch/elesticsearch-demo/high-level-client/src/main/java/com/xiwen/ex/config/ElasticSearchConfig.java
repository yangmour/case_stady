package com.xiwen.ex.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/26 -20:15
 * @Version: 1.0
 */
@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.232.201", 9200, "http")));
    }
}
