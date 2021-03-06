package com.kieranflay.builditbigger;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.kieranflay.builditbigger.backend.myApi.MyApi;
import com.kieranflay.displayjokelib.MainJokeActivity;
import java.io.IOException;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnJoke = (Button) root.findViewById(R.id.joke_button);
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EndpointsAsyncTask.AsyncTaskResponseListener listener = new EndpointsAsyncTask.AsyncTaskResponseListener() {
                    @Override
                    public void onAsyncResponse(String joke) {
                        Intent displayJokeIntent = new Intent(getActivity(), MainJokeActivity.class);
                        displayJokeIntent.putExtra("JOKE", joke);
                        startActivity(displayJokeIntent);
                    }
                };
                new EndpointsAsyncTask(getActivity(), listener).execute();
            }

        });

        return root;
    }

}





