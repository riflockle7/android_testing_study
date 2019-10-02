package riflocike.co.kr.androidtesttdd

import android.content.Context
import android.media.VolumeShaper
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.JUnitCore
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    fun add1(a: Int, b: Int): Int {
        return Array(a) { 1 }.plus(Array(b) { 1 }).sum()
    }

    fun add2(a: Int, b: Int): Int {
        return a + b
    }
}