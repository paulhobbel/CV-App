/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.providers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.paulhobbel.cvapp.providers.models.Item;
import me.paulhobbel.cvapp.providers.models.Project;

public abstract class BaseProvider<T extends Item> {

    private RequestQueue queue;
    private String url;
    protected ProviderListener<T> listener;

    public BaseProvider(Context context, String url, ProviderListener<T> listener) {
        this.queue = Volley.newRequestQueue(context);
        this.url = url;
        this.listener = listener;
    }

    protected void enqueue(Request request) {
        request.setTag(getClass());
        queue.add(request);
    }

    public void getContent() {
        enqueue(new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<T> items = new ArrayList<>();

                try {
                    for(int i = 0; i < response.length(); i++) {
                        JSONObject item = response.getJSONObject(i);
                        items.add(parseObject(item));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                listener.onProviderSuccess(items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(listener != null) {
                    listener.onProviderError(error);
                }
            }
        }));
    }

    public abstract T parseObject(JSONObject item) throws JSONException;

    public interface ProviderListener<T extends Item> {
        void onProviderSuccess(List<T> items);
        void onProviderError(VolleyError error);
    }
}
