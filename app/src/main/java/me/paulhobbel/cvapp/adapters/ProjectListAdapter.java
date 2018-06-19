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

import java.util.List;

import butterknife.BindView;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.providers.models.Project;

public class ProjectListAdapter extends ItemListAdapter<Project, ProjectListAdapter.ViewHolder> {

    public ProjectListAdapter(List<Project> items, OnItemClickListener listener) {
        super(items, R.layout.project_list_item, listener);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Project project) {
        //holder.projectImage.setImageResource(project.getImage());
        holder.projectName.setText(project.getName());
        holder.projectDescription.setText(project.getDescription());

        Picasso.get().cancelRequest(holder.projectImage);
        Picasso.get()
                .load(project.getImage())
                .fit()
                .centerCrop()
                .into(holder.projectImage);
    }

    @Override
    protected ViewHolder newViewHolder(View view) {
        return new ViewHolder(view);
    }

    class ViewHolder extends ItemListAdapter.ViewHolder {

        @BindView(R.id.projectImage)
        ImageView projectImage;
        @BindView(R.id.projectName)
        TextView projectName;
        @BindView(R.id.projectDescription)
        TextView projectDescription;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
