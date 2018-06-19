/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.ExperienceListAdapter;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.generators.ExcperienceGenerator;
import me.paulhobbel.cvapp.models.Experience;

public class ExperienceFragment extends ItemsFragment<Experience> {

    public static ExperienceFragment newInstance() {
        return newInstance(ExperienceFragment.class, R.id.nav_experiences, R.string.experiences);
    }

    @Override
    protected ItemListAdapter newAdapter() {
        return new ExperienceListAdapter(ExcperienceGenerator.experiences(), this);
    }

    @Override
    public void onItemClick(Experience item) {

    }
}
