package com.dingxiang.springboot.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer index) {
        System.out.println("执行异步任务" + index);
    }

    @Async
    public void executeAsyncTaskPlus(Integer index) {

        System.out.println("执行异步任务＋１：" + (index + 1));
    }
}
