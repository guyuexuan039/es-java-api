package com.abc.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author 030
 * @date 21:15 2021/8/22
 * @description
 */
public class ESTest_Doc_Update {

    public static void main(String[] args) throws Exception{

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 修改数据
        UpdateRequest request = new UpdateRequest();

        // 对哪一个索引进行修改呢，哪一条数据呢，一条数据就是一个doc
        request.index("user").id("1001").doc(XContentType.JSON, "sex", "女");

        UpdateResponse updateResponse = esClient.update(request, RequestOptions.DEFAULT);

        System.out.println(updateResponse.getResult());

        esClient.close();

    }
}
