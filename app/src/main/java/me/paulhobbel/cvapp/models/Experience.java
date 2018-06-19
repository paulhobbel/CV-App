/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringRes;

public class Experience extends Item implements Parcelable {

    public static final Creator<Experience> CREATOR = new Creator<Experience>() {
        @Override
        public Experience createFromParcel(Parcel in) {
            return new Experience(in);
        }

        @Override
        public Experience[] newArray(int size) {
            return new Experience[size];
        }
    };

    private String job;
    private String company;

    public Experience(Parcel in) {
        super(in);
        job = in.readString();
        company = in.readString();
    }

    public Experience(Builder builder) {
        super(builder);
        job = builder.job;
        company = builder.company;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(job);
        dest.writeString(company);
    }

    public static class Builder extends Item.Builder<Builder, Experience> {

        String job;
        String company;

        public Builder setJob(String job) {
            this.job = job;
            return getThis();
        }

        public Builder setCompany(String company) {
            this.company = company;
            return getThis();
        }

        @Override
        public Experience build() {
            return new Experience(this);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
