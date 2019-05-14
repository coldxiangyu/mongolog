package com.mongo.mongolog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;

/**
 * @author coldxiangyu
 * @date 2019/5/6 上午9:05
 */
@Data
public class MongoLogEntity {
    @Id
    private String id;
    private String level;
    private String logger;
    private String thread;
    private String message;
    private String timestamp;

    public void setDate(long date) {
        this.timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public String getDate() {
        return timestamp;
    }
}
