/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.ExperienceListAdapter;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.providers.BaseProvider;
import me.paulhobbel.cvapp.providers.ExperienceProvider;
import me.paulhobbel.cvapp.providers.models.Experience;

public class ExperienceFragment extends ItemsFragment<Experience> {

    public static ExperienceFragment newInstance() {
        return newInstance(ExperienceFragment.class, R.id.nav_experiences, R.string.experiences);
    }

    @Override
    protected BaseProvider newProvider() {
        return new ExperienceProvider(getContext(), this);
    }

    @Override
    protected ItemListAdapter newAdapter(List<Experience> items) {
        return new ExperienceListAdapter(items, this);
    }

    @Override
    public void onItemClick(Experience item) {

    }
}
