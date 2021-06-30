package top.mask.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * ClassName ESClient
 * Create by hx
 * Date 2021/6/30 6:06 下午
 */

public class ESCreateIndex {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("es");
        CreateIndexResponse response = esClient.indices().create(request, RequestOptions.DEFAULT);
        //响应状态
        boolean acknowledged = response.isAcknowledged();
        System.out.println("索引操作："+acknowledged);

        //关闭es客户端
        esClient.close();
    }
}
