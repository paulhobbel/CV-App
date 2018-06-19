/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.generators;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Project;

public class ProjectGenerator {
    private final static List<Project> projects = new ArrayList<>();

    static {
        new Project.Builder()
                .setName("Weerstation")
                .setDescription("Weer station project bla blabla bla bla")
                .setStartDate(LocalDate.of(2017, 9, 1))
                .setEndDate(LocalDate.of(2017, 10, 24))
                .setImageRes(R.drawable.project_weerstation)
                .buildAndAdd(projects);

        new Project.Builder()
                .setName("Boebot")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .setStartDate(LocalDate.of(2017, 11, 7))
                .setEndDate(LocalDate.of(2018, 1, 16))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(projects);

        new Project.Builder()
                .setName("Festivalplanner")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .setStartDate(LocalDate.of(2018, 2, 1))
                .setEndDate(LocalDate.of(2018, 4, 4))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(projects);

        new Project.Builder()
                .setName("Discover Essteling")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .setStartDate(LocalDate.of(2018, 4, 26))
                .setEndDate(LocalDate.of(2018, 6, 19))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(projects);
    }

    public static List<Project> projects() {
        return projects;
    }
}
