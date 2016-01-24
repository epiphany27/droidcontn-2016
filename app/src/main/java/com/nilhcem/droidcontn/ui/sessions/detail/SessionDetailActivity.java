package com.nilhcem.droidcontn.ui.sessions.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilhcem.droidcontn.DroidconApp;
import com.nilhcem.droidcontn.R;
import com.nilhcem.droidcontn.data.app.model.Session;
import com.nilhcem.droidcontn.data.app.model.Speaker;
import com.nilhcem.droidcontn.ui.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class SessionDetailActivity extends BaseActivity<SessionDetailPresenter> implements SessionDetailView {

    private static final String EXTRA_SESSION = "session";

    @Inject Picasso picasso;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.session_detail_photo) ImageView photo;
    @Bind(R.id.session_detail_title) TextView title;
    @Bind(R.id.session_detail_subtitle) TextView subtitle;
    @Bind(R.id.session_detail_description) TextView description;
    @Bind(R.id.session_detail_speakers_container) ViewGroup speakersContainer;

    private Session session;

    public static Intent createIntent(@NonNull Context context, @NonNull Session session) {
        return new Intent(context, SessionDetailActivity.class)
                .putExtra(EXTRA_SESSION, session);
    }

    @Override
    protected SessionDetailPresenter newPresenter() {
        return new SessionDetailPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session_detail);
        setSupportActionBar(toolbar);
        DroidconApp.get(this).component().inject(this);

        session = getIntent().getParcelableExtra(EXTRA_SESSION);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        List<Speaker> speakers = session.getSpeakers();
        if (speakers != null && !speakers.isEmpty()) {
            picasso.load(speakers.get(0).getPhoto()).resize(600, 0).into(photo);
        }

        title.setText(session.getTitle());
        subtitle.setText("May 29, 2015, 10:00 - 11:00 AM\nRoom 1 (L2)");
        description.setText(session.getDescription());
    }
}