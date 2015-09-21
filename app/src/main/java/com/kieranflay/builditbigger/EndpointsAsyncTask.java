package com.kieranflay.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.kieranflay.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Kieran on 16/08/2015.
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private MyApi myApiService = null;
    private Context context;
    AsyncTaskResponseListener listener;
    ProgressDialog progressDialog;

    public EndpointsAsyncTask(Context context, AsyncTaskResponseListener listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("loading...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            // Running against a deployed GCE build - for localhost build comment out the next 2 lines
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://upbeat-isotope-103014.appspot.com/_ah/api/");


            // For localhost build uncomment the code below
//                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        // options for running against local devappserver
//                        // - 10.0.2.2 is localhost's IP address in Android emulator
//                        // - turn off compression when running against local devappserver
//                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });


            myApiService = builder.build();
        }

        try {
            return myApiService.getJokeRequest().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (progressDialog != null)
        {
            progressDialog.dismiss();
        }

        try {
            listener.onAsyncResponse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface AsyncTaskResponseListener {
        void onAsyncResponse(String joke) throws IOException;
    }
}
