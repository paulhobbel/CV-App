/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.generators;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Diploma;

public class DiplomaGenerator {
    private static final List<Diploma> diplomas = new ArrayList<>();

    static {
        new Diploma.Builder()
                .setName("Havo")
                .setSchool("Hoeksch Lyceum")
                .setLocation("Oud-Beijerland")
                .setStartDate(LocalDate.of(2012, 9, 1))
                .setEndDate(LocalDate.of(2017, 5, 25))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(diplomas);

        new Diploma.Builder()
                .setName("Technische Informatica Bachelor")
                .setSchool("Avans")
                .setLocation("Breda")
                .setStartDate(LocalDate.of(2017, 9, 1))
                .setImageRes(R.color.colorPrimaryLight)
                .buildAndAdd(diplomas);
    }

    public static List<Diploma> diplomas() {
        return diplomas;
    }
}
