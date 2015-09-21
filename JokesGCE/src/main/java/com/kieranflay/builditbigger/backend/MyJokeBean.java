package com.kieranflay.builditbigger.backend;

import com.kieranflay.Joke;

/**
 * Created by Kieran on 06/08/2015.
 */
public class MyJokeBean {

    String myJoke;

    public String getJoke() {
        Joke j = new Joke();
        myJoke = j.getJoke();
        return j.getJoke();
    }

    public void setJoke(String data) {
        Joke j = new Joke();
        myJoke = data;
        j.setJoke(data);
    }
}
