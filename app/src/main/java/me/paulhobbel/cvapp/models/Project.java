/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.models;

import android.os.Parcelable;

public class Project extends Item implements Parcelable {
    public Project(Builder builder) {
        super(builder);
    }

    public static class Builder extends Item.Builder<Builder, Project> {

        @Override
        public Project build() {
            return new Project(this);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
