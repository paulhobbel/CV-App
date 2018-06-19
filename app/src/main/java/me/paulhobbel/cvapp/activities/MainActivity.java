/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.activities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.fragments.DiplomasFragment;
import me.paulhobbel.cvapp.fragments.ExperienceFragment;
import me.paulhobbel.cvapp.fragments.NavigationFragment;
import me.paulhobbel.cvapp.fragments.ProfileFragment;
import me.paulhobbel.cvapp.fragments.ProjectsFragment;
import me.paulhobbel.cvapp.providers.models.Contact;
import me.paulhobbel.cvapp.utils.ContactUtils;

public class MainActivity extends AppCompatActivity implements NavigationActivity,
        NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getHeaderView(0)
                .findViewById(R.id.drawerProfileContainer)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Contact me = new Contact(
                                "Paul Hobbel",
                                "paulhobbel@hotmail.com",
                                "+31612189992");
                        ContactUtils.addContactActivity(MainActivity.this, me);
                    }
                });

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance(), ProfileFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        drawerToggle.syncState();

        return super.onOptionsItemSelected(item);
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
                break;
            case R.id.nav_diplomas:
                fragment = DiplomasFragment.newInstance();
                break;
            case R.id.nav_experiences:
                fragment = ExperienceFragment.newInstance();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragment != null) {
            // Little bit tricky, but as long as .replace is used and no other fragments are
            // added to this activity we should be fine
            if(fragmentManager.getFragments().get(0).getClass() != fragment.getClass()) {
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }

            drawerLayout.closeDrawers();
            return true;
        }

        return false;
    }

    @Override
    public void onNavigationFragmentAttach(NavigationFragment fragment) {
        navigationView.setCheckedItem(fragment.getNavigationId());

        drawerLayout.removeDrawerListener(drawerToggle);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToggle);
    }
}
