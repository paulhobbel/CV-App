/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.listeners;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.activities.MainActivity;
import me.paulhobbel.cvapp.activities.ProjectsActivity;

public class DrawerNavigationListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private DrawerLayout drawer;

    public DrawerNavigationListener(Context context, DrawerLayout drawer) {
        this.context = context;
        this.drawer = drawer;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                context.startActivity(MainActivity.createIntent(context));
                break;
            case R.id.nav_projects:
                context.startActivity(ProjectsActivity.createIntent(context));
        }
        drawer.closeDrawers();

        return true;
    }
}
