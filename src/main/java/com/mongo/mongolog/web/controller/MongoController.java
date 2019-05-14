package com.mongo.mongolog.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author coldxiangyu
 * @date 2019/5/7 下午9:36
 */
@Slf4j
@Controller
public class MongoController {
    @Autowired
    private MongoRepository mongoRepository;

    @RequestMapping("/index")
    public String test(ModelMap map){
        log.info("--------------------------");
        return "mongo";

    }
}
