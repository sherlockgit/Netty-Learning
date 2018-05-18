package handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池相关
 * author: 小宇宙
 * date: 2018/5/18
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executorService;

    public TimeServerHandlerExecutePool (int maxoolSize, int queueSize) {

        executorService = new ThreadPoolExecutor(Runtime.getRuntime()
                .availableProcessors(), maxoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute (Runnable task) {
        executorService.execute(task);
    }

}
