package com.kieranflay.builditbigger;

import android.content.Context;
import android.test.InstrumentationTestCase;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Reference used for test:
// https://github.com/vshivam/ud867-project/blob/master/app/src/androidTest/java/com/udacity/gradle/builditbigger/AsyncTaskAndroidTest.java

public class AsyncTaskTest extends InstrumentationTestCase implements EndpointsAsyncTask.AsyncTaskResponseListener {

    CountDownLatch countDownLatch;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        countDownLatch = new CountDownLatch(1);
    }

    public void testVerifyAsyncTaskResponse() throws Throwable {

        final Context context = getInstrumentation().getTargetContext();
        final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(context, AsyncTaskTest.this);

        runTestOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  endpointsAsyncTask.execute();
                                  try {
                                      countDownLatch.await(30, TimeUnit.SECONDS);
                                  } catch (InterruptedException e) {
                                      e.printStackTrace();
                                  }
                              }
                          }
        );
    }

    @Override
    public void onAsyncResponse(String resultJoke) throws IOException {
        if (resultJoke.equals("") || resultJoke.equals(null)) {
            assertTrue(false);
        } else {
            assertTrue(true);
        }
        countDownLatch.countDown();
    }
}