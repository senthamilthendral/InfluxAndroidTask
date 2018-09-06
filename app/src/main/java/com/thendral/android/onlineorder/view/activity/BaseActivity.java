package com.thendral.android.onlineorder.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.ActivityBaseLayoutBinding;

/**
 * The Abstract class which can be extended and has base things to handle in common.
 * This class extends the {@link AppCompatActivity}
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBaseLayoutBinding activityBaseLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_base_layout);
        setupToolBar(activityBaseLayoutBinding.toolbar);
    }

    /**
     * Fragment holder. Given fragment be placed in the container
     *
     * @param primaryFragment fragment to be added
     */
    protected void setPrimaryFragment(final Fragment primaryFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.contentContainer, primaryFragment, primaryFragment.getClass().getName());
        if (!isFinishing()) {
            ft.commitAllowingStateLoss();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_orderonline, menu);
        return true;
    }

    /**
     * Method to setup the action bar in the activity
     *
     * @param toolbar - toolBar which to be set as Activity Action Bar
     */
    private void setupToolBar(final Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
