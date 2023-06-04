package com.atguigu.syt.hosp.dao.mongo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/02 -19:03
 * @Version: 1.0
 */
@SpringBootTest
public class MongoTemplateTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testAdd() {

        User insert = mongoTemplate.insert(new User(null, "cs2", 10, "cs@163.com", new Date()));
        System.out.println(insert);
        User save = mongoTemplate.save(new User(null, "cs3", 10, "cs@163.com", new Date()));
        System.out.println(save);

    }

    @Test
    public void testFindAll() {

        List<User> all = mongoTemplate.findAll(User.class);
        all.forEach(System.out::println);

    }

    @Test
    public void testDel() {

        DeleteResult result = mongoTemplate.remove(Query.query(Criteria.where("_id").is("647c27e377b9915a573f7876")), User.class);
        System.out.println(result.getDeletedCount());

    }

    @Test
    public void testUpdate() {

        Update update = new Update();
        update.set("age", 10);
//        UpdateResult age = mongoTemplate.updateMulti(Query.query(Criteria.where("_id").is("647c27e277b9915a573f7875")), update, User.class);
        Criteria criteria = Criteria.where("age").lte(18);
        Query query = Query.query(criteria);
        UpdateResult age = mongoTemplate.updateMulti(query, update, User.class);

    }

    @Test
    public void testUpsert() {

        Update update = new Update();
        update.set("cs3", 11);
        Criteria criteria = Criteria.where("name").is("cs3");
        Query query = Query.query(criteria);
        UpdateResult age = mongoTemplate.upsert(query, update, User.class);

    }

    @Test
    public void testFind() {


        Criteria criteria = Criteria.where("name").regex("c");
        Query query = Query.query(criteria)
                .skip(1)
                .limit(1);
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users);

    }

}
