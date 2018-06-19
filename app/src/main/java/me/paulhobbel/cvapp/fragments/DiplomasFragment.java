/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.DiplomaListAdapter;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.providers.BaseProvider;
import me.paulhobbel.cvapp.providers.DiplomaProvider;
import me.paulhobbel.cvapp.providers.models.Diploma;

public class DiplomasFragment extends ItemsFragment<Diploma> {

    public static DiplomasFragment newInstance() {
        return newInstance(DiplomasFragment.class, R.id.nav_diplomas, R.string.diplomas);
    }

    @Override
    protected BaseProvider newProvider() {
        return new DiplomaProvider(getContext(), this);
    }

    @Override
    protected ItemListAdapter newAdapter(List<Diploma> items) {
        return new DiplomaListAdapter(items, this);
    }

    @Override
    public void onItemClick(Diploma item) {

    }
}
