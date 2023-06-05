package com.atguigu.syt.hosp.repository;

import com.atguigu.syt.model.hosp.Department;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -18:11
 * @Version: 1.0
 */
public interface DepartmentRepository extends MongoRepository<Department, ObjectId> {

    Department findByHoscodeAndDepcode(String hoscode, String Depcode);
}
