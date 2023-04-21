package com.example.demo.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.example.demo.repository")
//@ComponentScan(basePackages = {"com.example.demo.service"})
//public class Config extends AbstractElasticsearchConfiguration {
//
//    @Override
//    @Bean
//    public RestHighLevelClient elasticsearchClient() {
//         ClientConfiguration config = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//
//        return RestClients.create(config).rest();
//    }
//}

@Configuration
public class Config {
        @Bean
        public RestClient getRestClient() {
            RestClient restClient = RestClient.builder(
                    new HttpHost("localhost", 9200)).build();
            return restClient;
        }
        @Bean
        public ElasticsearchTransport getElasticsearchTransport() {
            return new RestClientTransport(
                    getRestClient(), new JacksonJsonpMapper());
        }
        @Bean
        public ElasticsearchClient getElasticsearchClient(){
            ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
            return client;
        }
    }
