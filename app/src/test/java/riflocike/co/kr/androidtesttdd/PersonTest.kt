package riflocike.co.kr.androidtesttdd

import org.junit.Test

import junit.framework.TestCase.assertTrue
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class PersonTest {
    @Test
    fun test() {
        //mock 을 통해 Person 객체를 생성해줍니다.
        val p = mock(Person::class.java)

        //p 객체가 존재하는지 확인합니다.
        assertTrue(p != null)

        //when 함수를 통애 p 객체의 getName, getAge 반환값을 정해줍니다.
        `when`(p.name).thenReturn("BlackJin")
        `when`(p.age).thenReturn(27)

        //p 의 반환 값이 기대값과 같은지 확인 합니다.
        assertTrue("BlackJin" == p.name)
        assertTrue(27 == p.age)
    }
}