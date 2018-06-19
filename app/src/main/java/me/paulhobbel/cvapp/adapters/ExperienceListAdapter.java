/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.adapters;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import butterknife.BindView;
import me.paulhobbel.cvapp.CVApplication;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.providers.models.Experience;

public class ExperienceListAdapter extends ItemListAdapter<Experience, ExperienceListAdapter.ViewHolder> {

    public ExperienceListAdapter(List<Experience> items, OnItemClickListener<Experience> listener) {
        super(items, R.layout.experience_list_item, listener);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Experience item) {
        //holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        CVApplication application = CVApplication.getInstance();

        if(item.isFinished()) {
            holder.experienceDate.setText(application.getString(R.string.date_divider_present, item.getStartDate().format(formatter)));
        } else {
            holder.experienceDate.setText(application.getString(R.string.date_divider, item.getStartDate().format(formatter), item.getEndDate().format(formatter)));
        }

        holder.experienceCompany.setText(item.getCompany());

        Picasso.get().cancelRequest(holder.itemImage);
        Picasso.get().load(item.getImage()).fit().centerCrop().into(holder.itemImage);
        Log.d("WOLLA", "onBindViewHolder: " + item.getImage());
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

        @BindView(R.id.experienceDate)
        TextView experienceDate;
        @BindView(R.id.experienceCompany)
        TextView experienceCompany;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
