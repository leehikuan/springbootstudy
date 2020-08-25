package com.leehikuan.springbootstudy.async;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@Slf4j
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/queryTask")
    public String queryTask(){
        String result="";
        Future<String> future=taskService.doTask();
        for(;;){
            if(future.isDone()){
                result="完毕";
                break;
            }
        }
        log.info("TaskController-queryTask执行完毕");
        return result;
    }
}
