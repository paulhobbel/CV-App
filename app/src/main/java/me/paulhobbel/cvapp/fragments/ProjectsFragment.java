/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.activities.ProjectActivity;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.adapters.ProjectListAdapter;
import me.paulhobbel.cvapp.generators.ProjectGenerator;
import me.paulhobbel.cvapp.models.Project;

public class ProjectsFragment extends ItemsFragment<Project> {

    public static ProjectsFragment newInstance() {
        return newInstance(ProjectsFragment.class, R.id.nav_projects, R.string.projects);
    }

    @Override
    protected ItemListAdapter newAdapter() {
        return new ProjectListAdapter(ProjectGenerator.projects(), this);
    }

    @Override
    public void onItemClick(Project project) {
        startActivity(ProjectActivity.createIntent(getContext(), project));
    }
}
