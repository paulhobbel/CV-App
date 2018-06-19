/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.generators;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Experience;

public class ExcperienceGenerator {
    private static final List<Experience> experiences = new ArrayList<>();

    static {
        new Experience.Builder()
                .setName("Programmeur")
                .setJob("Programmeur")
                .setCompany("AW Investments")
                .setStartDate(LocalDate.of(2015, 1, 1))
                .setEndDate(LocalDate.of(2018, 4, 16))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(experiences);

        new Experience.Builder()
                .setName("Customer Relations")
                .setJob("Customer Relations")
                .setCompany("IKEA Breda")
                .setStartDate(LocalDate.of(2018, 4, 16))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(experiences);

    }

    public static List<Experience> experiences() {
        return experiences;
    }
}
