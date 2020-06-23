package io.droidcrew.recycler

import android.os.SystemClock
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ScrollPerfTest {

    private lateinit var device: UiDevice

    @get:Rule
    var mainActivityActivityTestRule = ActivityPerfTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    @PerformanceTest(
        processName = PACKAGE_NAME,
        perfType = PerformanceTest.PerfType.NUM_JANKY,
        threshold = 1,
        assertionType = PerformanceTest.AssertionType.LESS_OR_EQUAL,
        tag = "Constraint"
    )
    fun testFirst() {

        Espresso.onView(ViewMatchers.withText("First list"))
            .perform(ViewActions.click())

        SystemClock.sleep(1000)

        mainActivityActivityTestRule.startIteration()
        for (i in 0..10) {
            device.swipe(200, 1500, 500, 700, 5)
            SystemClock.sleep(500)
        }
    }

    @Test
    @PerformanceTest(
        processName = PACKAGE_NAME,
        perfType = PerformanceTest.PerfType.NUM_JANKY,
        threshold = 1,
        assertionType = PerformanceTest.AssertionType.LESS_OR_EQUAL,
        tag = "Linear   "
    )
    fun testSecond() {

        Espresso.onView(ViewMatchers.withText("Second list"))
            .perform(ViewActions.click())

        SystemClock.sleep(1000)

        mainActivityActivityTestRule.startIteration()
        for (i in 0..10) {
            device.swipe(200, 1500, 500, 700, 5)
            SystemClock.sleep(500)
        }
    }

    @Test
    @PerformanceTest(
        processName = PACKAGE_NAME,
        perfType = PerformanceTest.PerfType.NUM_JANKY,
        threshold = 1,
        assertionType = PerformanceTest.AssertionType.LESS_OR_EQUAL,
        tag = "Recycler  "
    )
    fun testThird() {

        Espresso.onView(ViewMatchers.withText("Third list"))
            .perform(ViewActions.click())

        SystemClock.sleep(1000)

        mainActivityActivityTestRule.startIteration()
        for (i in 0..10) {
            device.swipe(200, 1500, 500, 700, 5)
            SystemClock.sleep(500)
        }
    }

    companion object {
        private const val PACKAGE_NAME = "io.droidcrew.recycler"
    }
}