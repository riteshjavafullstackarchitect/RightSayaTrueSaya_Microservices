package com.rightsaya.microservices.platform.testing.application.miscellenous;

import com.rightsaya.functional.programs.RunExecuteJavaCodes;

import java.util.concurrent.*;

import static org.springframework.cloud.client.discovery.ReactiveDiscoveryClient.LOG;

public class RightSayaMisellenousCodes implements RunExecuteJavaCodes {


    @Override
    public void runExecuteJavaCodes() {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        ExecutorService executorA = Executors.newSingleThreadExecutor();

        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executorService.schedule(() -> {
            // ...
            return "Hello world";
        }, 1, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
            // ...
        }, 1, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFutureA = executorService.scheduleAtFixedRate(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFutureB = executorService.scheduleWithFixedDelay(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        if(future.isDone()) {
            String result = future.resultNow();
        }

        if(scheduledFuture.isDone()) {
            scheduledFuture.resultNow();
        }

        ExecutorService executorServiceC = Executors.newFixedThreadPool(10);

        Future<String> futureC = executorServiceC.submit(() -> {
            // ...
            Thread.sleep(10000l);
            return "Hello world";
        });

        if (futureC.isDone() && !futureC.isCancelled()) {
            try {
                String str = futureC.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        RiteshThreadFactory factory = new RiteshThreadFactory(
                "RiteshThreadFactory");
        for (int i = 0; i < 10; i++) {
            Thread t = factory.newThread(() -> {
                // ...
                try {
                    Thread.sleep(10000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //return "Hello world";
            });
            t.start();

        }


       // value.orElse(createDefault());

        // value.orElseGet(() -> createDefault());
    }


    public class Invoker implements Executor {
        @Override
        public void execute(Runnable r) {
            r.run();
        }
    }


    public class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                LOG.info(Thread.currentThread().getName() +
                        " is waiting");
                barrier.await();
                LOG.info(Thread.currentThread().getName() +
                        " is released");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void start() {

            CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
                // ...
                LOG.info("All previous tasks are completed");
            });

            Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
            Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
            Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

            if (!cyclicBarrier.isBroken()) {
                t1.start();
                t2.start();
                t3.start();
            }
        }

        static Semaphore semaphore = new Semaphore(10);

        public void execute() throws InterruptedException {

            LOG.info("Available permit : " + semaphore.availablePermits());
            LOG.info("Number of threads waiting to acquire: " +
                    semaphore.getQueueLength());

            if (semaphore.tryAcquire()) {
                try {
                    // ...
                }
                finally {
                    semaphore.release();
                }
            }

        }

    }

    public class RiteshThreadFactory implements ThreadFactory {
        private int threadId;
        private String name;

        public RiteshThreadFactory(String name) {
            threadId = 1;
            this.name = name;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, name + "-Thread_" + threadId);
            LOG.info("created new thread with id : " + threadId +
                    " and name : " + t.getName());
            threadId++;
            return t;
        }
    }
}



