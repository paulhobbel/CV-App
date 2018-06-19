/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.providers;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.ZonedDateTime;

import me.paulhobbel.cvapp.providers.models.Project;

public class ProjectProvider extends BaseProvider<Project> {
    public ProjectProvider(Context context, ProviderListener<Project> listener) {
        super(context, "https://api.paulhobbel.me/portfolio/projects", listener);
    }

    @Override
    public Project parseObject(JSONObject project) throws JSONException {
        Project.Builder builder = new Project.Builder()
                .setName(project.getString("name"))
                .setDescription(project.getString("description"))
                .setImage(project.getString("image"))
                .setStartDate(ZonedDateTime.parse(project.getString("startDate")).toLocalDate());

        if (project.has("endDate")) {
            builder.setEndDate(ZonedDateTime.parse(project.getString("endDate")).toLocalDate());
        }

        return builder.build();
    }
}
