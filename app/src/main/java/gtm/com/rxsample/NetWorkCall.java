package gtm.com.rxsample;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 4/19/2017.
 */

public class NetWorkCall {

    static String TAG = NetWorkCall.class.getName();

    public static void networkCall() throws IOException {

        URL mURL = new URL("https://api.github.com/users/gowthamkumar7");
        HttpURLConnection mConnection = (HttpURLConnection) mURL.openConnection();

        mConnection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));


        StringBuilder total = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            total.append(line).append('\n');
        }
        Log.i(TAG, "networkCall: " + total);
    }


}
