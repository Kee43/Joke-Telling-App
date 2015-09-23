# Joke Telling Application
Udacity Android Nanodegree - Project 4: Build it Bigger

This project contains an app with multiple flavors that uses
multiple libraries and Google Could Endpoints. The app consists
of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

# References used in this project
* Starting point: https://github.com/udacity/ud867/tree/master/FinalProject
* https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start
* http://developer.android.com/guide/components/intents-filters.html
* https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
* https://developers.google.com/mobile-ads-sdk/docs/admob/android/interstitial
* http://www.tutorialspoint.com/android/android_loading_spinner.htm

# Project Components
* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

# Project Behavior
* App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.

# Pre-requisites
* Android SDK v22
* Android Build Tools v22.0.1
* Android Support Repository r16 (for v22.2.1)

# License
* Copyright 2014 The Android Open Source Project, Inc.
* Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
