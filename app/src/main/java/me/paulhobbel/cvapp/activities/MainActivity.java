/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.fragments.NavigationFragment;
import me.paulhobbel.cvapp.fragments.ProfileFragment;
import me.paulhobbel.cvapp.fragments.ProjectsFragment;

public class MainActivity extends AppCompatActivity implements NavigationActivity, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ProfileFragment.newInstance(), ProfileFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //navigationView.setCheckedItem(R.id.nav_profile);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_profile:
                fragment = ProfileFragment.newInstance();
                break;
            case R.id.nav_projects:
                fragment = ProjectsFragment.newInstance();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragment != null) {
            if(fragmentManager.getFragments().get(0).getClass() != fragment.getClass()) {
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }

            //drawerLayout.closeDrawers();

            return true;
        }

        return false;
    }

    @Override
    public void onNavigationFragmentAttach(NavigationFragment fragment) {
        navigationView.setCheckedItem(fragment.getNavigationId());
        drawerLayout.closeDrawers();
    }
}
