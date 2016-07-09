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
    private ConditionVariable waiter;
    @SuppressWarnings("unchecked")
    public void test() {
        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        waiter = new ConditionVariable();
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(this);
        waiter.block();
    }

    @Override
    public void onReceived(String joke) {
        result = joke;
        if(result==null){
            Log.e(LOG_TAG, "Retrieved a null string ");
        }
        else if(result.isEmpty()){
            Log.e(LOG_TAG, "Retrieved a empty string ");
        }
        else{
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        }
        assertFalse(TextUtils.isEmpty(result));
        waiter.open();
    }
}