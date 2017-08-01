package io.bucare.www.kotlintutorial.domain.executor.impl;

import io.bucare.www.kotlintutorial.domain.executor.Executor;
import io.bucare.www.kotlintutorial.domain.interactors.base.AbstractInteractor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This singleton class will make sure that each interactor operation gets a background thread.
 * <p/>
 */
@Singleton public class ThreadExecutor implements Executor {
  private static final int CORE_POOL_SIZE = 3;
  private static final int MAX_POOL_SIZE = 5;
  private static final int KEEP_ALIVE_TIME = 120;
  private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
  private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();
  private ThreadPoolExecutor mThreadPoolExecutor;

  @Inject public ThreadExecutor() {
    long keepAlive = KEEP_ALIVE_TIME;
    mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                                                 MAX_POOL_SIZE,
                                                 keepAlive,
                                                 TIME_UNIT,
                                                 WORK_QUEUE);
  }

  @Override public void execute(final AbstractInteractor interactor) {
    mThreadPoolExecutor.submit(new Runnable() {
      @Override public void run() {
        // run the main logic
        interactor.run();

        // mark it as finished
        interactor.onFinished();
      }
    });
  }
}
