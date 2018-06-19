/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.DiplomaListAdapter;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.generators.DiplomaGenerator;
import me.paulhobbel.cvapp.models.Diploma;

public class DiplomasFragment extends ItemsFragment<Diploma> {

    public static DiplomasFragment newInstance() {
        return newInstance(DiplomasFragment.class, R.id.nav_diplomas, R.string.diplomas);
    }

    @Override
    protected ItemListAdapter newAdapter() {
        return new DiplomaListAdapter(DiplomaGenerator.diplomas(), this);
    }

    @Override
    public void onItemClick(Diploma item) {

    }
}
