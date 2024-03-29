package riflocike.co.kr.androidtesttdd

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class EspressoTest{
    @get:Rule
    var myActivityActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    @Test
    fun startTest(){
        //editText에 값 입력후 키보드 닫음.
        onView(withId(R.id.name_et)).perform(typeText("qwertyui"))
        onView(withId(R.id.id_et)).perform(typeText("ace69"))
        onView(withId(R.id.pwd_et)).perform(typeText("123456"), closeSoftKeyboard())

        //textView 값이 Hello Wordl! 인지 확인
        onView(withId(R.id.name_board_tv)).check(matches(withText("NAME : qwertyui")))
        onView(withId(R.id.id_board_tv)).check(matches(withText("ID : ace69")))
        onView(withId(R.id.pwd_board_tv)).check(matches(withText("PWD : 123456")))

        //Button 클릭
        onView(withId(R.id.done_btn)).perform(click())
    }
}