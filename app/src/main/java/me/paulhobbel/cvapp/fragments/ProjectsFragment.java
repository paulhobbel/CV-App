/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.activities.ProjectActivity;
import me.paulhobbel.cvapp.adapters.ProjectListAdapter;
import me.paulhobbel.cvapp.generators.ProjectGenerator;
import me.paulhobbel.cvapp.models.Project;

public class ProjectsFragment extends NavigationFragment implements ProjectListAdapter.OnItemClickListener {

    @BindView(R.id.projectList)
    RecyclerView projectList;

    ProjectListAdapter adapter;

    public static ProjectsFragment newInstance() {
        return newInstance(ProjectsFragment.class, R.id.nav_projects, R.string.projects);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ProjectListAdapter(ProjectGenerator.projects(), this);
        projectList.setLayoutManager(new LinearLayoutManager(getContext()));
        projectList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Project project) {
        startActivity(ProjectActivity.createIntent(getContext(), project));
    }
}