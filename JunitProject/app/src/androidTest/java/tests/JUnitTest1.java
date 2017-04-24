package tests;

import android.support.test.rule.ActivityTestRule;
import org.junit.Test;
import org.junit.Rule;
import junitproject.android.com.junitproject.MainActivity;

/**
 * Created by JustinonTG on 4/24/17.
 */

public class JUnitTest1 {

    @Rule
    public ActivityTestRule<MainActivity>
            mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void test1() {

    }
}
