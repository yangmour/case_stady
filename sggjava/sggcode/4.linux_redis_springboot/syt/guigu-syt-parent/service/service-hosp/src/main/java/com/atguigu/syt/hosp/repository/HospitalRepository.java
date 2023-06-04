package com.atguigu.syt.hosp.repository;

import com.atguigu.syt.model.hosp.Hospital;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:55
 * @Version: 1.0
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital, ObjectId> {

    Hospital findByHoscode(String hoscode);

}
