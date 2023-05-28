package com.xiwen.es.dao;

import com.xiwen.es.bean.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/28 -17:34
 * @Version: 1.0
 */
@Repository
public interface ElasticsearchDao extends ElasticsearchRepository<Product, Integer> {

    List<Product> findByPriceBetweenOrProductNameIn(double price, double price2, Collection<String> productName);

}
