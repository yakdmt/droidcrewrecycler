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

private const val PREFETCH_ITEMS = true

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
        threshold = 100,
        assertionType = PerformanceTest.AssertionType.LESS_OR_EQUAL,
        tag = "Constraint"
    )
    fun testFirst() {

        if (PREFETCH_ITEMS) {
            Espresso.onView(ViewMatchers.withText("Use prefetcher"))
                .perform(ViewActions.click())
            SystemClock.sleep(1000)
        }

        Espresso.onView(ViewMatchers.withText("Constraint"))
            .perform(ViewActions.click())

        SystemClock.sleep(1000)

        mainActivityActivityTestRule.startIteration()
        for (i in 0..5) {
            device.swipe(200, 1500, 500, 700, 5)
            SystemClock.sleep(500)
        }
    }

    @Test
    @PerformanceTest(
        processName = PACKAGE_NAME,
        perfType = PerformanceTest.PerfType.NUM_JANKY,
        threshold = 100,
        assertionType = PerformanceTest.AssertionType.LESS_OR_EQUAL,
        tag = "Linear    "
    )
    fun testSecond() {

        if (PREFETCH_ITEMS) {
            Espresso.onView(ViewMatchers.withText("Use prefetcher"))
                .perform(ViewActions.click())
            SystemClock.sleep(1000)
        }

        Espresso.onView(ViewMatchers.withText("Linear"))
            .perform(ViewActions.click())

        SystemClock.sleep(1000)

        mainActivityActivityTestRule.startIteration()
        for (i in 0..5) {
            device.swipe(200, 1500, 500, 700, 5)
            SystemClock.sleep(500)
        }
    }

    @Test
    @PerformanceTest(
        processName = PACKAGE_NAME,
        perfType = PerformanceTest.PerfType.NUM_JANKY,
        threshold = 100,
        assertionType = PerformanceTest.AssertionType.LESS_OR_EQUAL,
        tag = "Recycler  "
    )
    fun testThird() {

        if (PREFETCH_ITEMS) {
            Espresso.onView(ViewMatchers.withText("Use prefetcher"))
                .perform(ViewActions.click())
            SystemClock.sleep(1000)
        }

        Espresso.onView(ViewMatchers.withText("Recycler"))
            .perform(ViewActions.click())

        SystemClock.sleep(1000)

        mainActivityActivityTestRule.startIteration()
        for (i in 0..5) {
            device.swipe(200, 1500, 500, 700, 5)
            SystemClock.sleep(500)
        }
    }

    companion object {
        private const val PACKAGE_NAME = "io.droidcrew.recycler"
    }
}