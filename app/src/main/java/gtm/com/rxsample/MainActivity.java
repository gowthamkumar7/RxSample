package gtm.com.rxsample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class MainActivity extends AppCompatActivity {


    String TAG = MainActivity.class.getName();
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* new AsyncTask() {
            @Override
            protected Void doInBackground(Object[] objects) {


                try {
                    NetWorkCall.networkCall();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();*/
        Model model = new Model();
        model.setId(1);
        Observable<Model> observable = Observable.just(model);
        compositeDisposable = new CompositeDisposable();



        Observer mObserser = new Observer<Model>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Model model) {
                Log.i(TAG, "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        };

      //  compositeDisposable.dispose();
        observable.subscribe(mObserser);
        Log.i(TAG, "deposable sizes: " + compositeDisposable.size());

        // Subscription m= observable.subscribe(mObserser);

    }
}
