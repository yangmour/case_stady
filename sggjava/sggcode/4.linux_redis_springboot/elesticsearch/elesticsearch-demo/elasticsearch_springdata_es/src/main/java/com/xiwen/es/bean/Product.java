package com.xiwen.es.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/28 -17:35
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product", shards = 1, replicas = 1)
public class Product implements Serializable {
    @Id
    private Integer id;
    @Field(value = "name", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String productName;
    @Field(type = FieldType.Integer)
    private Integer store;
    @Field(type = FieldType.Double, index = true, store = false)
    private double price;
}