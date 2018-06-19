/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.threeten.bp.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.paulhobbel.cvapp.R;
import me.paulhobbel.cvapp.models.Item;

public class ProjectActivity extends AppCompatActivity {

    private static final String PROJECT_EXTRA = "PROJECT_EXTRA";

    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.projectImage)
    ImageView projectImage;
    @BindView(R.id.projectName)
    TextView projectName;
    @BindView(R.id.projectDescription)
    TextView projectDescription;
    @BindView(R.id.projectStartDate)
    TextView projectStartDate;
    @BindView(R.id.projectEndDate)
    TextView projectEndDate;

    public static Intent createIntent(Context context, Item project) {
        Intent intent = new Intent(context, ProjectActivity.class);
        intent.putExtra(PROJECT_EXTRA, project);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Item project = getIntent().getParcelableExtra(PROJECT_EXTRA);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(project.getName());
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                projectImage.setAlpha(1.0f - Math.abs(verticalOffset / (float) appBar.getTotalScrollRange()));
            }
        });

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, d MMM yyyy");

        projectImage.setImageResource(project.getImageRes());
        projectName.setText(project.getName());
        projectName.setVisibility(View.GONE);
        projectDescription.setText(project.getDescription());
        projectStartDate.setText(getString(R.string.start_date, project.getStartDate().format(formatter)));
        projectEndDate.setText(getString(R.string.end_date, project.getEndDate().format(formatter)));
    }

}
