package com.mongo.mongolog.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongo.mongolog.entity.MongoLogEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MongoAppender extends UnsynchronizedAppenderBase<ILoggingEvent> implements ApplicationContextAware{
    private static MongoTemplate mongoTemplate;
    private String collectionName;

    @Override
    protected void append(ILoggingEvent event) {
        if (!started) {
            return;
        }

        MongoLogEntity mongoLogEntity = new MongoLogEntity();
        mongoLogEntity.setLevel(event.getLevel().toString());
        mongoLogEntity.setLogger(event.getLoggerName());
        mongoLogEntity.setThread(event.getThreadName());
        mongoLogEntity.setMessage(event.getFormattedMessage());
        mongoLogEntity.setDate(event.getTimeStamp());
        mongoTemplate.save(mongoLogEntity);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext.getAutowireCapableBeanFactory().getBean(MongoTemplate.class) != null) {
            mongoTemplate = applicationContext.getAutowireCapableBeanFactory().getBean(MongoTemplate.class);
            LoggerFactory.getLogger(this.getClass()).info("[ApplicationContext] Autowire MongoTemplate, MongoAppender is ready.");
        }
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}