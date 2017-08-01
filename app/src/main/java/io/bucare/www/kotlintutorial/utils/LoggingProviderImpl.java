package io.bucare.www.kotlintutorial.utils;

import com.orhanobut.logger.Logger;
import javax.inject.Singleton;

/**
 * Created by joseanmun on 7/7/16.
 */
@Singleton public class LoggingProviderImpl implements LoggingProvider {
  @Override public void log(int logPriority, String tag, String message, Throwable throwable) {
    Logger.log(logPriority,
               tag,
               message,
               throwable);
  }

  @Override public void xml(String xml) {
    Logger.xml(xml);
  }

  @Override public void json(String json) {
    Logger.json(json);
  }

  @Override public void wtf(String log, Object... args) {
    Logger.wtf(log,
               args);
  }

  @Override public void v(String log, Object... args) {
    Logger.v(log,
             args);
  }

  @Override public void w(String log, Object... args) {
    Logger.w(log,
             args);
  }

  @Override public void e(String log, Object... args) {
    Logger.e(log,
             args);
  }

  @Override public void d(String log, Object... args) {
    Logger.d(log,
             args);
  }

  @Override public void i(String log, Object... args) {
    Logger.i(log,
             args);
  }

  @Override public void init() {

  }
}
