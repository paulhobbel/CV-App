/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.providers;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.ZonedDateTime;

import me.paulhobbel.cvapp.providers.models.Experience;

public class ExperienceProvider extends BaseProvider<Experience> {
    public ExperienceProvider(Context context, ProviderListener<Experience> listener) {
        super(context, "https://api.paulhobbel.me/portfolio/experiences", listener);
    }

    @Override
    public Experience parseObject(JSONObject item) throws JSONException {
        Experience.Builder builder = new Experience.Builder()
                .setName(item.getString("name"))
                .setCompany(item.getString("company"))
                .setImage(item.getString("image"))
                .setStartDate(ZonedDateTime.parse(item.getString("startDate")).toLocalDate());

        if (item.has("endDate")) {
            builder.setEndDate(ZonedDateTime.parse(item.getString("endDate")).toLocalDate());
        }

        return builder.build();
    }
}
