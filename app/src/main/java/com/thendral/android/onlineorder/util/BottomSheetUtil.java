package com.thendral.android.onlineorder.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;

import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.FragmentHomeBinding;

public final class BottomSheetUtil {

    public static void initBottomSheet(final Activity activity, final FragmentHomeBinding fragmentHomeBinding) {
        // init the bottom sheet behavior
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(fragmentHomeBinding.bottomSheet);

        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        // set the peek height
        bottomSheetBehavior.setPeekHeight(120);
        // set hide able or not
        bottomSheetBehavior.setHideable(false);
        // set callback for changes

        // TODO Get Currency Value dynamically
        String amount = String.format(fragmentHomeBinding.totalAmount.getContext().getString(R.string.amount_with_currency), "AED", "0");
        fragmentHomeBinding.totalAmount.setText(amount);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    fragmentHomeBinding.expandedLayout.setVisibility(View.GONE);
                    fragmentHomeBinding.imageArrow.setImageDrawable(activity.getDrawable(R.drawable.ic_up_arrow));
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    fragmentHomeBinding.expandedLayout.setVisibility(View.VISIBLE);
                    fragmentHomeBinding.imageArrow.setImageDrawable(activity.getDrawable(R.drawable.ic_down_arrow));
                }
            }


            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
