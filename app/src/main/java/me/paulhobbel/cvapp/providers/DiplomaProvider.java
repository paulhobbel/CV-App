/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.providers;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.ZonedDateTime;

import me.paulhobbel.cvapp.providers.models.Diploma;

public class DiplomaProvider extends BaseProvider<Diploma> {
    public DiplomaProvider(Context context, ProviderListener<Diploma> listener) {
        super(context, "https://api.paulhobbel.me/portfolio/diplomas", listener);
    }

    @Override
    public Diploma parseObject(JSONObject item) throws JSONException {
        Diploma.Builder builder = new Diploma.Builder()
                .setName(item.getString("name"))
                .setSchool(item.getString("school"))
                .setLocation(item.getString("location"))
                .setImage(item.getString("image"))
                .setStartDate(ZonedDateTime.parse(item.getString("startDate")).toLocalDate());

        if (item.has("endDate")) {
            builder.setEndDate(ZonedDateTime.parse(item.getString("endDate")).toLocalDate());
        }

        return builder.build();
    }
}
