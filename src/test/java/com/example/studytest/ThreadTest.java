package com.example.studytest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    ExecutorService executorService;

    @Test
    void threadTest() {
        executorService = Executors.newFixedThreadPool(10);
        ArrayList<String> testList = new ArrayList<>();

        HashMap<Integer, List<String>> result = new HashMap<>();

        for(int i = 0; i < 1000; i++) {
            testList.add("test" + i);
        }
        for (int i = 0; i < 10; i++) {
            List<String> subList = testList.subList(i * 100, (i + 1) * 100);
            TestService testService = new TestService(subList, i, result);
            executorService.submit(testService);
        }
        try {

            while(!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                System.out.println(executorService.isTerminated());
            }
            System.out.println("result.get().size() = " + result.size());
            result.forEach((k, v) -> {
                System.out.println("i = " + k);
                v.stream().forEach(str -> {
                    System.out.println(k + " : " + str);
                });
                System.out.println("------------------------");
            });


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public class TestService implements Runnable {

        private int idx;
        private List<String> dataList;
        private HashMap<Integer, List<String>> result;

        public TestService(List<String> dataList, int idx, HashMap<Integer, List<String>> result) {
            this.idx = idx;
            this.dataList = dataList;
            this.result = result;
        }

        @Override
        public void run() {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                int poolSize = threadPoolExecutor.getPoolSize();
                String threadName = Thread.currentThread().getName();

                ArrayList<String> tmpList = new ArrayList<>();
                dataList.forEach(d -> tmpList.add(d + "_complete"));

                result.put(idx, tmpList);

                System.out.println("[총 스레드 개수:" + poolSize + "] 작업 스레드 이름: "+threadName);
                Thread.sleep(200);
                executorService.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public List<String> getDataList() {
            return dataList;
        }

        public void setDataList(List<String> dataList) {
            this.dataList = dataList;
        }
    }
}
