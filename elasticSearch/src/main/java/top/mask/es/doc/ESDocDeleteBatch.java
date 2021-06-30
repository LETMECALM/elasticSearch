package top.mask.es.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * ClassName ESDocInsert
 * Create by hx
 * Date 2021/6/30 6:46 下午
 */

public class ESDocDeleteBatch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //批量删除数据
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("es-doc-batch").id("1001"));
        request.add(new DeleteRequest().index("es-doc-batch").id("1002"));
        request.add(new DeleteRequest().index("es-doc-batch").id("1003"));
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getItems());


        esClient.close();
    }
}
