/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.adapters;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import butterknife.BindView;
import me.paulhobbel.cvapp.CVApplication;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.providers.models.Diploma;

public class DiplomaListAdapter extends ItemListAdapter<Diploma, DiplomaListAdapter.ViewHolder> {

    public DiplomaListAdapter(List<Diploma> items, OnItemClickListener<Diploma> listener) {
        super(items, R.layout.diploma_list_item, listener);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Diploma item) {
        holder.itemName.setText(item.getName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        CVApplication application = CVApplication.getInstance();

        if(item.isFinished()) {
            holder.diplomaDate.setText(application.getString(R.string.date_divider_present, item.getStartDate().format(formatter)));
        } else {
            holder.diplomaDate.setText(application.getString(R.string.date_divider, item.getStartDate().format(formatter), item.getEndDate().format(formatter)));
        }

        holder.diplomaCompany.setText(application.getString(R.string.date_divider, item.getSchool(), item.getLocation()));

        Picasso.get().cancelRequest(holder.itemImage);
        Picasso.get().load(item.getImage()).fit().centerCrop().into(holder.itemImage);
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

        @BindView(R.id.diplomaDate)
        TextView diplomaDate;
        @BindView(R.id.diplomaCompany)
        TextView diplomaCompany;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
