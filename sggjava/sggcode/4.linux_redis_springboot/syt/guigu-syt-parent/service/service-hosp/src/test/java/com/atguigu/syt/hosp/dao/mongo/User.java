package com.atguigu.syt.hosp.dao.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user") //指定mongodb中的集合名字
public class User {

    @Id
    private ObjectId id;
    private String name;
    private Integer age;
    private String email;
    private Date createDate;
}