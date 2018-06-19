/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class CVApplication extends Application {

    private static CVApplication instance;

    public static CVApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AndroidThreeTen.init(this);
    }
}
