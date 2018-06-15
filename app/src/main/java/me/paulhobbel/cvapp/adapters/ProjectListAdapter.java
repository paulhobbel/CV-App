/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Project;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

    private final List<Project> projects;
    private final OnItemClickListener listener;

    public ProjectListAdapter(List<Project> projects, OnItemClickListener listener) {
        this.projects = projects;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project project = getItem(position);

        if(project != null) {
            holder.projectImage.setImageResource(project.getImage());
            holder.projectName.setText(project.getName());
            holder.projectDescription.setText(project.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public Project getItem(int position) {
        if(position < 0 || position >= projects.size()) return null;

        return projects.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.projectImage)
        ImageView projectImage;
        @BindView(R.id.projectName)
        TextView projectName;
        @BindView(R.id.projectDescription)
        TextView projectDescription;

        public ViewHolder(View itemView) {
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

    public interface OnItemClickListener {
        void onItemClick(Project project);
    }
}
