package com.nilhcem.droidcontn.ui.sessions.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.nilhcem.droidcontn.R;
import com.nilhcem.droidcontn.data.model.Slot;
import com.nilhcem.droidcontn.ui.BaseActivity;

public class SessionsListActivity extends BaseActivity<SessionsListPresenter> implements SessionsListView {

    private static final String EXTRA_SLOT = "slot";

    private Slot slot;

    public static Intent createIntent(@NonNull Context context, @NonNull Slot slot) {
        return new Intent(context, SessionsListActivity.class)
                .putExtra(EXTRA_SLOT, slot);
    }

    @Override
    protected SessionsListPresenter newPresenter() {
        return new SessionsListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessions_list);
        slot = getIntent().getParcelableExtra(EXTRA_SLOT);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TODO");
    }
}