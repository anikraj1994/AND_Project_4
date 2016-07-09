package me.anikraj.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityTestCase;
import android.test.AndroidTestCase;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by anikr on 7/8/2016.
 */
public class NonEmptyStringTest extends AndroidTestCase implements OnJokeReceivedListener {

    private static final String LOG_TAG = "NonEmptyStringTest";
    String result = null;
    @SuppressWarnings("unchecked")
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(this);
    }

    @Override
    public void onReceived(String joke) {
        result = joke;
        assertFalse(TextUtils.isEmpty(result));
        if(result!=null){
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        }
    }
}