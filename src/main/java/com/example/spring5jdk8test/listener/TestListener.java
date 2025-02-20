package com.example.spring5jdk8test.listener;

import com.example.spring5jdk8test.service.AnimalService;
import com.example.spring5jdk8test.service.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 不在BaseService上声明@Primary时，会报错
        BaseService baseService = applicationContext.getBean(BaseService.class);
        AnimalService animalService = applicationContext.getBean(AnimalService.class);
    }
}
