/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.activities;

import me.paulhobbel.cvapp.fragments.NavigationFragment;

public interface NavigationActivity {
    void onNavigationFragmentAttach(NavigationFragment fragment);
}
