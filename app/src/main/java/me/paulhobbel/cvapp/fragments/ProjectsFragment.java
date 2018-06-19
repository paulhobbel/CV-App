/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.activities.ProjectActivity;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.adapters.ProjectListAdapter;
import me.paulhobbel.cvapp.providers.BaseProvider;
import me.paulhobbel.cvapp.providers.ProjectProvider;
import me.paulhobbel.cvapp.providers.models.Project;

public class ProjectsFragment extends ItemsFragment<Project> implements BaseProvider.ProviderListener<Project> {

    public static ProjectsFragment newInstance() {
        return newInstance(ProjectsFragment.class, R.id.nav_projects, R.string.projects);
    }

    @Override
    protected BaseProvider newProvider() {
        return new ProjectProvider(getContext(), this);
    }

    @Override
    protected ItemListAdapter newAdapter(List<Project> items) {
        return new ProjectListAdapter(items, this);
    }

    @Override
    public void onItemClick(Project project) {
        startActivity(ProjectActivity.createIntent(getContext(), project));
    }
}
