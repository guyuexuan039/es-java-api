package com.abc.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
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
public class ESTest_Doc_Get {

    public static void main(String[] args) throws Exception{

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 查询获取数据
        GetRequest request = new GetRequest();

        request.index("user").id("1001");

        GetResponse getResponse = esClient.get(request, RequestOptions.DEFAULT);

        System.out.println(getResponse.getSourceAsString());

        esClient.close();

    }
}
