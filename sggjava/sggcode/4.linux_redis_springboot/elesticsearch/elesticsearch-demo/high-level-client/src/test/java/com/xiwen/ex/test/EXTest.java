package com.xiwen.ex.test;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

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

    @Test
    public void testCreate1() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        CreateIndexResponse cs = indices.create(new CreateIndexRequest("cs"), RequestOptions.DEFAULT);
        System.out.println(cs);
    }

    @Test
    public void testDel1() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        AcknowledgedResponse cs = indices.delete(new DeleteIndexRequest("cs"), RequestOptions.DEFAULT);
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
