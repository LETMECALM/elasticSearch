package top.mask.es.doc;

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
import top.mask.es.entity.UserInfo;

import java.io.IOException;

/**
 * ClassName ESDocInsert
 * Create by hx
 * Date 2021/6/30 6:46 下午
 */

public class ESDocInsertBatch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //批量插入数据
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("es-doc-batch").id("1001").source(XContentType.JSON,"name","张三"));
        request.add(new IndexRequest().index("es-doc-batch").id("1002").source(XContentType.JSON,"name","李四"));
        request.add(new IndexRequest().index("es-doc-batch").id("1003").source(XContentType.JSON,"name","王武"));
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getItems());


        esClient.close();
    }
}
