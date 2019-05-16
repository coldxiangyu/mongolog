package com.mongo.mongolog.controller;

import com.mongo.mongolog.entity.MongoLogEntity;
import com.mongo.mongolog.repository.MongoLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author coldxiangyu
 * @date 2019/5/7 下午9:36
 */
@Slf4j
@Controller
public class MongoController {
    @Autowired
    private MongoLogRepository mongoLogRepository;
    @GetMapping("/mongo")
    public String test(ModelMap modelMap){
        log.info("---------------start controller");
        modelMap.put("mongoEntities", getMongoLogs());
        modelMap.put("title", "mongolog");
        return "mongo";
    }
    private List<Map> getMongoLogs(){
        List<MongoLogEntity> mongoLogEntities = mongoLogRepository.findAll();
        List<Map> list= new ArrayList<>();
        for(int i=0;i<mongoLogEntities.size();i++){
            Map map= new HashMap();
            map.put("level",mongoLogEntities.get(i).getLevel());
            map.put("logger",mongoLogEntities.get(i).getLogger());
            map.put("thread",mongoLogEntities.get(i).getThread());
            map.put("message",mongoLogEntities.get(i).getMessage());
            map.put("timestamp",mongoLogEntities.get(i).getDate());
            list.add(map);
        }
        return list;
    } }
