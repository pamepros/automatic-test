package com.automatic.android.tests;

import com.automatic.android.R;
import com.automatic.android.activities.MainActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mTestMainActivity;
    private FrameLayout mListFrameLayout;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mTestMainActivity = getActivity();
        mListFrameLayout = (FrameLayout) mTestMainActivity.findViewById(R.id.trips_frame);
    }

    public void testPreconditions() {
        assertNotNull("mFirstTestActivity is null", mTestMainActivity);
        assertNotNull("mListFrameLayout is not in view or is null", mListFrameLayout);
    }

}