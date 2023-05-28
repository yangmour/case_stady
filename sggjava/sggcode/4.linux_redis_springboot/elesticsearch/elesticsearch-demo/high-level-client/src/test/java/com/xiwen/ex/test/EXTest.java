package com.xiwen.ex.test;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/26 -20:20
 * @Version: 1.0
 */
@SpringBootTest
public class EXTest {

    @Autowired
    public RestHighLevelClient restHighLevelClient;

    // DSL查询:restHighLevelClient对象的search()方法完成的
    private void parseDoc(SearchResponse getResponse) {
        System.out.println("原始信息" + getResponse);
        System.out.println("-------------------------------");
        System.out.println("took:" + getResponse.getTook());
        System.out.println("timed_out:" + getResponse.isTimedOut());
        System.out.println("total:" + getResponse.getHits().getTotalHits().value);
        SearchHit[] hits = getResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit);
        }

    }


    @Test
    public void testDSL2() throws IOException {
        SearchSourceBuilder source = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("title", "手机"));
        boolQueryBuilder.must(QueryBuilders.rangeQuery("price")
                .gt(3500)
                .lte(5500));

        source.query(boolQueryBuilder);
        source.from(0);
        source.size(1);
//        source.fetchSource(new String[]{"id","title","price"},null);
        AggregationBuilder agg = AggregationBuilders.terms("agg_group")
                .field("category");
        agg.subAggregation(AggregationBuilders.max("max_agg2").field("price"));
        source.aggregation(agg);

        SearchRequest request = new SearchRequest(new String[]{"my_index"}, source);

        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        parseDoc(search);
    }

    @Test
    public void testDSL() throws IOException {
        SearchSourceBuilder source = new SearchSourceBuilder();
        source.query(QueryBuilders.matchAllQuery());
        SearchRequest request = new SearchRequest(new String[]{"my_index"}, source);

        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        parseDoc(search);
    }

    //文档操作
    private void printDoc(GetResponse getResponse) {
        System.out.println("原始信息" + getResponse);
        System.out.println("-------------------------------");
        System.out.println("_id:" + getResponse.getId());
        System.out.println("_index:" + getResponse.getIndex());
        System.out.println("_type:" + getResponse.getType());
        System.out.println(getResponse.getSource());

    }

    // 查文档
    @Test
    public void test() throws IOException {
        GetRequest request = new GetRequest("cs", "1");
        GetResponse documentFields = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        printDoc(documentFields);
    }

    // 修改
    @Test
    public void testUpdateDocument() throws IOException {
        //局部修改
        /*UpdateRequest request = new UpdateRequest("cs", "1");
        IndexRequest doc = new IndexRequest();
        doc.source("title", "cs2");
        request.doc(doc);
        UpdateResponse update = restHighLevelClient.update(request, RequestOptions.DEFAULT);*/

        //覆盖式
        IndexRequest request = new IndexRequest("cs");
        request.id("1");
        request.source("title", "cs2");
        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);

    }

    //删文档
    @Test
    public void testDelDocument() throws IOException {

        DeleteRequest request = new DeleteRequest("cs", "1");
        DeleteResponse delete = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    }

    //添加文档
    @Test
    public void testAddDocument() throws IOException {
        IndexRequest request = new IndexRequest("cs");
        request.id("1");
        request.source("title", "cs", "id", "01", "category", "hh", "price", "1000");
        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    //以下是索引库的操作
    //获取索引库
    @Test
    public void testGetIndex() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        GetIndexRequest request = new GetIndexRequest("cs");
        indices.get(request, RequestOptions.DEFAULT);
    }

    //创建索引库映射
    @Test
    public void testIndexMapping() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
//        PutMappingRequest request = new PutMappingRequest("cs");
//        request.source(
//                "{\n" +
//                        "    \"properties\":{\n" +
//                        "      \"id\":{\n" +
//                        "        \"type\":\"long\",\n" +
//                        "        \"index\": false\n" +
//                        "      },\n" +
//                        "      \"title\":{\n" +
//                        "        \"type\":\"text\",\n" +
//                        "        \"index\": true,\n" +
//                        "        \"store\": true,\n" +
//                        "        \"analyzer\": \"ik_smart\",\n" +
//                        "        \"search_analyzer\": \"ik_max_word\"\n" +
//                        "      },\n" +
//                        "      \"category\":{\n" +
//                        "        \"type\": \"keyword\",\n" +
//                        "        \"index\": true,\n" +
//                        "        \"store\": true\n" +
//                        "      },\n" +
//                        "      \"images\":{\n" +
//                        "        \"type\":\"keyword\",\n" +
//                        "        \"index\": false\n" +
//                        "      },\n" +
//                        "      \"price\":{\n" +
//                        "        \"type\": \"double\",\n" +
//                        "        \"index\": true\n" +
//                        "      }\n" +
//                        "    }\n" +
//                        "  }", XContentType.JSON);
//
//        AcknowledgedResponse acknowledgedResponse = indices.putMapping(request, RequestOptions.DEFAULT);
//        System.out.println(acknowledgedResponse);

        //创建加映射1
        /*CreateIndexRequest request = new CreateIndexRequest("cs2");
        request.source(
                "{\n" +
                        "    \"properties\":{\n" +
                        "      \"id\":{\n" +
                        "        \"type\":\"long\",\n" +
                        "        \"index\": false\n" +
                        "      },\n" +
                        "      \"title\":{\n" +
                        "        \"type\":\"text\",\n" +
                        "        \"index\": true,\n" +
                        "        \"store\": true,\n" +
                        "        \"analyzer\": \"ik_smart\",\n" +
                        "        \"search_analyzer\": \"ik_max_word\"\n" +
                        "      },\n" +
                        "      \"category\":{\n" +
                        "        \"type\": \"keyword\",\n" +
                        "        \"index\": true,\n" +
                        "        \"store\": true\n" +
                        "      },\n" +
                        "      \"images\":{\n" +
                        "        \"type\":\"keyword\",\n" +
                        "        \"index\": false\n" +
                        "      },\n" +
                        "      \"price\":{\n" +
                        "        \"type\": \"double\",\n" +
                        "        \"index\": true\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }", XContentType.JSON);
        AcknowledgedResponse acknowledgedResponse = indices.create(request, RequestOptions.DEFAULT);
        */

        /*//创建加映射2
        CreateIndexRequest request = new CreateIndexRequest("cs3");
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
        xContentBuilder.startObject();
        {
            xContentBuilder.startObject("mappings");
            {
                xContentBuilder.startObject("properties");
                {
                    xContentBuilder.startObject("id");
                    {
                        xContentBuilder.field("type","text");
                        xContentBuilder.field("index",false);
                        xContentBuilder.field("store", false);
                    }
                    xContentBuilder.endObject();

                xContentBuilder.startObject("title");
                xContentBuilder.field("type","text");
                xContentBuilder.field("index",true);
                xContentBuilder.field("store",true);
                xContentBuilder.field("analyzer","ik_smart");
                xContentBuilder.field("search_analyzer","ik_max_word");
                xContentBuilder.endObject();
                }
                xContentBuilder.endObject();
            }
            xContentBuilder.endObject();
        }
        xContentBuilder.endObject();

        request.source(xContentBuilder);
        AcknowledgedResponse acknowledgedResponse = indices.create(request, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse);*/

        //创建加映射3
        CreateIndexRequest request = new CreateIndexRequest("cs4");

        HashMap<String, Object> title = new HashMap<>();
        title.put("type", "text");
        title.put("index", true);
        title.put("analyzer", "ik_smart");
        HashMap<String, Object> author = new HashMap<>();
        author.put("type", "text");
        author.put("index", true);
        author.put("analyzer", "ik_smart");

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("title", title);
        properties.put("author", author);

        Map<String, Object> mappings = new HashMap<>();
        mappings.put("properties", properties);

        request.mapping(mappings);
        AcknowledgedResponse acknowledgedResponse = indices.create(request, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse);


    }


    @Test
    public void testCreate1() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        CreateIndexResponse cs = indices.create(new CreateIndexRequest("cs2"), RequestOptions.DEFAULT);
        System.out.println(cs);
    }

    @Test
    public void testDel1() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        AcknowledgedResponse cs = indices.delete(new DeleteIndexRequest("cs3"), RequestOptions.DEFAULT);
        System.out.println(cs);
    }

    @Test
    public void testOpenOrClose1() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        AcknowledgedResponse cs = indices.open(new OpenIndexRequest("cs"), RequestOptions.DEFAULT);
        System.out.println(cs);
    }

    @Test
    public void testGet1() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        GetIndexResponse cs1 = indices.get(new GetIndexRequest("cs"), RequestOptions.DEFAULT);
        System.out.println(cs1.getSettings());
        System.out.println(cs1.getSetting("cs", "index.creation_date"));
        boolean cs = indices.exists(new GetIndexRequest("cs"), RequestOptions.DEFAULT);
        System.out.println(cs ? "存在" : "不存在");
    }

    // 异步的
    @Test
    public void testAsync1() throws IOException, InterruptedException {
        IndicesClient indices = restHighLevelClient.indices();

        ActionListener<Boolean> listener = new ActionListener<Boolean>() {
            @Override
            public void onResponse(Boolean aBoolean) {
                System.out.println(aBoolean ? "存在" : "不存在");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("异常");
                e.printStackTrace();
            }
        };
        GetIndexRequest request = new GetIndexRequest("cs");
        indices.existsAsync(request, RequestOptions.DEFAULT, listener);
        Thread.sleep(1000);
    }
}
