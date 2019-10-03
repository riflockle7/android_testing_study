package riflocike.co.kr.androidtesttdd

import org.junit.Before
import org.junit.Test
import riflocike.co.kr.androidtesttdd.ui_test.UITestActivity

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UITest {
    lateinit var uiActivityTestImpl : UIActivityTest

    class UIActivityTest(private val activity: UITestActivity) {
        fun isBtnSelectedInActivity(): Boolean {
            return activity.isBtnSelected()
        }
    }

    // 각 테스트 함수 실행전에 수행되는 메소드
    @Before
    fun setUp(){
        val activity = UITestActivity()
        activity.setupView()
        activity.isBtnSelected()

        uiActivityTestImpl = UIActivityTest(activity)
    }

    @Test
    fun testIsBtnSelected(){
        println(uiActivityTestImpl.isBtnSelectedInActivity())
    }
}