package com.automatic.android.tests;

import com.automatic.android.R;
import com.automatic.android.activities.MainActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mFirstTestActivity;
    private FrameLayout mListFrameLayout;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mFirstTestActivity = getActivity();
        mListFrameLayout = (FrameLayout) mFirstTestActivity.findViewById(R.id.trips_frame);
    }

    public void testPreconditions() {
        assertNotNull("mListFrameLayout is not in view or is null", mListFrameLayout);
    }

    /**
     * Tests the correctness of the initial text.
     */
//    public void testMyFirstTestTextView_labelText() {
//        //It is good practice to read the string from your resources in order to not break
//        //multiple tests when a string changes.
//        //final String expected = mFirstTestActivity.getString(R.string.my_first_test);
//        //final String actual = mFirstTestText.getText().toString();
//        assertEquals("mFirstTestText contains wrong text", expected, actual);
//    }
}