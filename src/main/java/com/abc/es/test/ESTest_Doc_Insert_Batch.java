package com.abc.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author 030
 * @date 21:15 2021/8/22
 * @description 批量插入数据
 */
public class ESTest_Doc_Insert_Batch {

    public static void main(String[] args) throws Exception{

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 批量插入数据
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "张三"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "李四"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "王五"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "王六"));

        BulkResponse bulkResponse = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(bulkResponse.getTook());
        System.out.println(bulkResponse.getItems());

        esClient.close();

    }
}
