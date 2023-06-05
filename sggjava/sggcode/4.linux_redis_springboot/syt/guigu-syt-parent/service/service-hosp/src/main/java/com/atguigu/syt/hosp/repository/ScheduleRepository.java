package com.atguigu.syt.hosp.repository;

import com.atguigu.syt.model.hosp.Schedule;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -18:11
 * @Version: 1.0
 */
public interface ScheduleRepository extends MongoRepository<Schedule, ObjectId> {

    Schedule findByHoscodeAndHosScheduleId(String hoscode, String HosScheduleId);

    Schedule findByHoscodeAndDepcodeAndHosScheduleId(String hoscode, String depcode, String HosScheduleId);

}
