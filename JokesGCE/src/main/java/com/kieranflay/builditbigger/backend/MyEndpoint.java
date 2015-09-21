/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.kieranflay.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.kieranflay.com",
                ownerName = "backend.builditbigger.kieranflay.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);
        return response;
    }

    @ApiMethod(name = "getJokeRequest")
    public MyJokeBean getJokeRequest() {
        MyJokeBean response = new MyJokeBean();
        response.getJoke();
        return response;
    }

    @ApiMethod(name = "setJokeRequest")
    public MyJokeBean setJokeRequest(@Named("joke") String joke) {
        MyJokeBean response = new MyJokeBean();
        response.setJoke(joke);
        return response;
    }
}
