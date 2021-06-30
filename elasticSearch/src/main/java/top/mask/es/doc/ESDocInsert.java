package top.mask.es.doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
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

public class ESDocInsert {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("es-java").id("1001");
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setAge(34);
        userInfo.setGrander("男");

        //向es插入数据，必须为json字符串
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(userInfo);
        request.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());


        esClient.close();
    }
}
