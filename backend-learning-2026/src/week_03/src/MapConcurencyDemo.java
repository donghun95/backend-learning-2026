package week_03.src;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class MapConcurencyDemo {
    public static void main(String[] args) throws InterruptedException {
        runTest(new HashMap<>(), "HashMap");
        runTest(new ConcurrentHashMap<>(), "ConcurrentHashMap");
    }
    private static void runTest(Map<Integer, Integer> map, String label) throws InterruptedException {
        int threadCount = 10;
        int perThread = 1000;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < perThread; j++) {
                    map.put(threadId * perThread + j, j);
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        int expected = threadCount * perThread;
        System.out.println(label + ":  기대 size " + expected + ", 실제 size " + map.size());
    }
}