package com.example.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class TestAsyncService {

    @Async
    public void asyncInvokeSimple() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("asyncInvokeSimple");
    }
    @Async
    public void asyncInvokeWithParameters(String s) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("asyncInvokeWithParameters,parameter="+s);
    }
    @Async
    public Future<String> asyncReturnFuture(int i) throws InterruptedException {
        Future<String> future;
        future = new AsyncResult<>("success "+i+" times!");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            future = new AsyncResult<>("exception");
//            e.printStackTrace();
//        }
        if(i==10){
            Thread.sleep(200);
        }
        return future;
    }

}
