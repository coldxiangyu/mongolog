package com.mongo.mongolog.repository;

import com.mongo.mongolog.entity.MongoLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author coldxiangyu
 * @date 2019/5/6 上午9:07
 */
public interface MongoLogRepository extends MongoRepository<MongoLogEntity, String> {
    List<MongoLogEntity> findAll();
}
