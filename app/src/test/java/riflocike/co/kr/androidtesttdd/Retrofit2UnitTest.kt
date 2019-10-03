package riflocike.co.kr.androidtesttdd

import org.junit.Test

import org.junit.Assert.*
import riflocike.co.kr.androidtesttdd.network.util.NetworkModel
import riflocike.co.kr.androidtesttdd.network.util.getInstance

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Retrofit2UnitTest {
    var api = getInstance()

    @Test
    fun Retrofit2LoginTest(){
        var response : NetworkModel = api?.get_userLogin("riflockle7", "abcd")?.execute()?.body() ?: NetworkModel(
            "",
            ""
        )

        println(response.toString())
        assertEquals(NetworkModel("riflockle7", "abcd"), response)
    }
}