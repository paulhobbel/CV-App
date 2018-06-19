/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.providers.models;

import android.os.Parcel;
import android.os.Parcelable;

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

    private String company;

    public Experience(Parcel in) {
        super(in);
        company = in.readString();
    }

    public Experience(Builder builder) {
        super(builder);
        company = builder.company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(company);
    }

    public static class Builder extends Item.Builder<Builder, Experience> {

        String company;

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
