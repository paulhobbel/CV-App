/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.providers.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

import org.threeten.bp.LocalDate;

import java.util.List;

public class Item implements Parcelable {

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    //private String image;

    //@DrawableRes
    private String image;

    public Item(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.image = builder.image;
    }

    protected Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        startDate = (LocalDate) in.readSerializable();
        endDate = (LocalDate) in.readSerializable();
        image = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getImage() {
        return image;
    }

    public boolean isFinished() {
        return endDate == null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeSerializable(startDate);
        dest.writeSerializable(endDate);
        dest.writeString(image);
    }

    public abstract static class Builder<B extends Builder<B, I>, I extends Item> {
        String name;
        String description;
        LocalDate startDate;
        LocalDate endDate;

        String image;

        public B setName(String name) {
            this.name = name;
            return getThis();
        }

        public B setDescription(String description) {
            this.description = description;
            return getThis();
        }

        public B setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return getThis();
        }

        public B setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return getThis();
        }

        public B setImage(String image) {
            this.image = image;
            return getThis();
        }

        public void buildAndAdd(List<I> list) {
            list.add(build());
        }

        public abstract I build();

        protected abstract B getThis();
    }
}
