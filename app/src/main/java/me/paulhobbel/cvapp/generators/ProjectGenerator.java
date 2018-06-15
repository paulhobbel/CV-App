/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.generators;

import org.threeten.bp.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Project;

public class ProjectGenerator {
    private final static List<Project> projects;

    static {
        projects = new ArrayList<>();
        projects.add(new Project(
                "Weerstation",
                "Weer station project bla blabla bla bla", LocalDateTime.now(), LocalDateTime.now(),
                R.drawable.project_weerstation));

        projects.add(new Project(
                "Boebot",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", LocalDateTime.now(), LocalDateTime.now(),
                R.color.colorPrimaryLight));

        projects.add(new Project(
                "Festivalplanner",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", LocalDateTime.now(), LocalDateTime.now(),
                R.color.colorPrimaryLight));

        projects.add(new Project(
                "Discover Essteling",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", LocalDateTime.now(), LocalDateTime.now(),
                R.color.colorPrimaryLight));
    }

    public static List<Project> projects() {
        return projects;
    }
}
