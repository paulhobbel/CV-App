/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.providers.BaseProvider;
import me.paulhobbel.cvapp.providers.models.Item;

public abstract class ItemsFragment<T extends Item> extends NavigationFragment implements
        ItemListAdapter.OnItemClickListener<T>, BaseProvider.ProviderListener<T> {

    @BindView(R.id.itemList)
    RecyclerView itemList;

    @LayoutRes
    private int fragmentRes;
    private ArrayList<T> items = new ArrayList<>();

    public ItemsFragment() {
        this(R.layout.fragment_items);
    }

    public ItemsFragment(@LayoutRes int fragmentRes) {
        this.fragmentRes = fragmentRes;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            items = savedInstanceState.getParcelableArrayList("items");
            Log.d("ITEMS_FRAGMENT", "onCreate: restored instance");
        } else {
            BaseProvider provider = newProvider();
            if (provider != null) {
                Log.d("ITEMS_FRAGMENT", "onCreate: getting content from provider");
                provider.getContent();
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(fragmentRes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemList.setLayoutManager(new LinearLayoutManager(getContext()));
        itemList.setAdapter(newAdapter(items));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("items", items);
    }

    protected abstract BaseProvider newProvider();

    protected abstract ItemListAdapter newAdapter(List<T> items);

    @Override
    public abstract void onItemClick(T item);

    @Override
    public void onProviderSuccess(List<T> newItems) {
        items.addAll(newItems);
        itemList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onProviderError(VolleyError error) {
        Log.d("ITEMS_FRAGMENT", "onProviderError: " + error);
        Toast.makeText(getContext(),"An error occured while fetching content", Toast.LENGTH_LONG).show();
    }
}