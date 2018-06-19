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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.models.Item;

public abstract class ItemsFragment<T extends Item> extends NavigationFragment implements
        ItemListAdapter.OnItemClickListener<T> {

    @BindView(R.id.itemList)
    RecyclerView itemList;

    @LayoutRes
    private int fragmentRes;

    public ItemsFragment() {
        this(R.layout.fragment_items);
    }

    public ItemsFragment(@LayoutRes int fragmentRes) {
        this.fragmentRes = fragmentRes;
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
        itemList.setAdapter(newAdapter());
    }

    protected abstract ItemListAdapter newAdapter();

    @Override
    public abstract void onItemClick(T item);
}