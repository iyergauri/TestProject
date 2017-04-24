package tests;

import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;
import org.junit.Test;
import org.junit.Rule;
import junitproject.android.com.junitproject.R;
import junitproject.android.com.junitproject.MainActivity;

/**
 * Created by JustinonTG on 4/24/17.
 */

public class JUnitTest1 {
    private int testTextViewId = R.id.text1;


    @Rule
    public ActivityTestRule<MainActivity>
            mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void test1() {
        TextView testTextView = (TextView) mainActivity.getActivity().findViewById(testTextViewId);
        String testTextVal = testTextView.getText().toString();

    }
}
