/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.adapters;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Experience;

public class ExperienceListAdapter extends ItemListAdapter<Experience, ExperienceListAdapter.ViewHolder> {

    public ExperienceListAdapter(List<Experience> items, OnItemClickListener<Experience> listener) {
        super(items, R.layout.experience_list_item, listener);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Experience item) {
        holder.itemImage.setImageResource(item.getImageRes());
        holder.itemName.setText(item.getName());
    }

    @Override
    protected ViewHolder newViewHolder(View view) {
        return new ViewHolder(view);
    }

    class ViewHolder extends ItemListAdapter.ViewHolder {

        @BindView(R.id.itemImage)
        ImageView itemImage;
        @BindView(R.id.itemName)
        TextView itemName;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
