/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import me.paulhobbel.cvapp.models.Item;

public abstract class ItemListAdapter<T extends Item, R extends ItemListAdapter.ViewHolder> extends RecyclerView.Adapter<R> {

    private final List<T> items;
    private final int itemLayoutRes;
    private final OnItemClickListener<T> listener;

    public ItemListAdapter(List<T> items, @LayoutRes int itemLayoutRes, OnItemClickListener<T> listener) {
        this.items = items;
        this.itemLayoutRes = itemLayoutRes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public R onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(itemLayoutRes, parent, false);

        return newViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull R holder, int position) {
        T item = getItem(position);
        if(item != null) {
            onBindViewHolder(holder, item);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position) {
        if(position < 0 || position >= items.size()) return null;

        return items.get(position);
    }

    protected abstract void onBindViewHolder(@NonNull R holder, @NonNull T item);

    protected abstract R newViewHolder(View view);

    abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.equals(itemView) && listener != null) {
                listener.onItemClick(getItem(getLayoutPosition()));
            }
        }
    }

    public interface OnItemClickListener<T extends Item> {
        void onItemClick(T project);
    }
}
