package top.mask.es.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * ClassName ESDocInsert
 * Create by hx
 * Date 2021/6/30 6:46 下午
 */

public class ESDocQuery {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //查询索引中全部数据
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        request.source(query);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();


        //条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30));
//        request.source(query);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();


        //分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // (当前页码-1) * 每页显示数据条数
//        builder.from(2);
//        builder.size(3);
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();


        //查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);

        // (当前页码-1) * 每页显示数据条数
//        builder.from(2);
//        builder.size(3);
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();


        //过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//
//        String[] excludes = {"age"};
//        String[] includes = {};
//        builder.fetchSource(includes,excludes);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();

        //组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("granger","男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",40));
//
//        builder.query(boolQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();

        //范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        rangeQuery.gte(30);
//        rangeQuery.lte(50);
//
//        builder.query(rangeQuery);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();

        //8.模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "王武").fuzziness(Fuzziness.ONE);
//
//
//        builder.query(fuzzyQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();


        //9.高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age",30);
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("age");
//        builder.highlighter(highlightBuilder);
//        builder.query(termQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();

        //9.聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("es-doc-batch");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        MaxAggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//
//
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        esClient.close();

        //9.分组查询
        SearchRequest request = new SearchRequest();
        request.indices("es-doc-batch");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");


        builder.aggregation(aggregationBuilder);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }


        esClient.close();
    }
}
