/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Diploma extends Item implements Parcelable {

    public static final Creator<Diploma> CREATOR = new Creator<Diploma>() {
        @Override
        public Diploma createFromParcel(Parcel in) {
            return new Diploma(in);
        }

        @Override
        public Diploma[] newArray(int size) {
            return new Diploma[size];
        }
    };

    private String school;
    private String location;

    public Diploma(Parcel in) {
        super(in);
        school = in.readString();
        location = in.readString();
    }

    public Diploma(Builder builder) {
        super(builder);
        school = builder.school;
        location = builder.location;
    }

    public String getSchool() {
        return school;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(school);
        dest.writeString(location);
    }

    public static class Builder extends Item.Builder<Builder, Diploma> {

        String school;
        String location;

        public Builder setSchool(String school) {
            this.school = school;
            return getThis();
        }

        public Builder setLocation(String location) {
            this.location = location;
            return getThis();
        }

        @Override
        public Diploma build() {
            return new Diploma(this);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
