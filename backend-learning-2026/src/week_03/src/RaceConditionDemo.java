package week_03.src;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionDemo {
    static int unsafeCount = 0;
    static int syncCount = 0;
    static final AtomicInteger atomicCount = new AtomicInteger(0);
    static synchronized void incSync() { syncCount++; }
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        int loopCount = 100_000;
        CountDownLatch readyLatch = new CountDownLatch(threadCount);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                readyLatch.countDown();
                try {
                    startLatch.await();
                    for (int j = 0; j < loopCount; j++) {
                        unsafeCount++;                

                        incSync();                 

                        atomicCount.incrementAndGet();  
              }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    doneLatch.countDown();
                }
            }).start();
        }
        readyLatch.await();   
        
        startLatch.countDown();  
        
        doneLatch.await();   
        
        int expected = threadCount * loopCount;
        System.out.println(" 기대값 : " + expected);
        System.out.println("unsafe (race condition): " + unsafeCount);
        System.out.println("synchronized: " + syncCount);
        System.out.println("AtomicInteger: " + atomicCount.get());
    }
}