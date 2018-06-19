/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import java.util.List;

import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Certificate;

public class CertificateListAdapter extends ItemListAdapter<Certificate, CertificateListAdapter.ViewHolder> {

    public CertificateListAdapter(List<Certificate> items, OnItemClickListener<Certificate> listener) {
        super(items, R.layout.project_list_item, listener);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Certificate item) {

    }

    @Override
    protected ViewHolder newViewHolder(View view) {
        return new ViewHolder(view);
    }

    class ViewHolder extends ItemListAdapter.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
