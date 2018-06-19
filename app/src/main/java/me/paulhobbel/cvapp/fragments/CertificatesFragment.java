/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.fragments;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.adapters.CertificateListAdapter;
import me.paulhobbel.cvapp.adapters.ItemListAdapter;
import me.paulhobbel.cvapp.generators.CertificateGenerator;
import me.paulhobbel.cvapp.models.Certificate;

public class CertificatesFragment extends ItemsFragment<Certificate> {

    public static CertificatesFragment newInstance() {
        return newInstance(CertificatesFragment.class, R.id.nav_certificates, R.string.certificates);
    }

    @Override
    protected ItemListAdapter newAdapter() {
        return new CertificateListAdapter(CertificateGenerator.certificates(), this);
    }

    @Override
    public void onItemClick(Certificate item) {

    }
}
