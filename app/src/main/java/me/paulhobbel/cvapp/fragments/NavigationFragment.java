/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.activities.NavigationActivity;

public class NavigationFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    protected static <E extends NavigationFragment> E newInstance(Class<E> fragmentClass, @IdRes int navigationId, @StringRes int title) {
        try {
            E fragment = fragmentClass.newInstance();

            Bundle arguments = new Bundle();
            arguments.putInt("NAV_ID_ARG", navigationId);
            arguments.putInt("TITLE_ARG", title);

            fragment.setArguments(arguments);

            return fragment;
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null) {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setTitle(getArguments().getInt("TITLE_ARG"));
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

            if(activity instanceof NavigationActivity) {
                ((NavigationActivity) activity).onNavigationFragmentAttach(this);
            }
        }
    }

    @IdRes
    public int getNavigationId() {
        return getArguments().getInt("NAV_ID_ARG");
    }
}
