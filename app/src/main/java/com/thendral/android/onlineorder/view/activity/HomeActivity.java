package com.thendral.android.onlineorder.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.thendral.android.onlineorder.view.fragment.HomeFragment;

/**
 * The Home activity extends the {@link BaseActivity} and responsible for loading the Home
 * Screen.
 */
public final class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPrimaryFragment(new HomeFragment());
    }
}
