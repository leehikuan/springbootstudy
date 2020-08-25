package com.leehikuan.springbootstudy.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@Slf4j
public class TaskService {

    @Async
    public Future<String> doTask(){
        log.info("进入doTask方法.............");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.info("doTask方法出错.............");
            return new AsyncResult<String>("执行失败");
        }
        log.info("TaskService-doTask方法执行完毕.............");
        return new AsyncResult<String>("执行成功");
    }
}
