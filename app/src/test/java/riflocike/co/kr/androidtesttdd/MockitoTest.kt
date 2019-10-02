package riflocike.co.kr.androidtesttdd

import org.junit.Assert
import org.junit.Test
import org.junit.runner.JUnitCore
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

public interface CalculatorService {
    fun add(input1: Double, input2: Double): Double
    fun subtract(input1: Double, input2: Double): Double
    fun multiply(input1: Double, input2: Double): Double
    fun divide(input1: Double, input2: Double): Double
}

// 테스트 대상
public class MathApplication {
    private var calcService: CalculatorService? = null

    // 주입 받는다.
    fun setCalculatorService(calcService: CalculatorService) {
        this.calcService = calcService;
    }

    public fun add(input1: Double, input2: Double): Double? {
        return calcService?.add(input1, input2);
    }

    public fun subtract(input1: Double, input2: Double): Double? {
        return calcService?.subtract(input1, input2);
    }

    public fun multiply(input1: Double, input2: Double): Double? {
        return calcService?.multiply(input1, input2);
    }

    public fun divide(input1: Double, input2: Double): Double? {
        return calcService?.divide(input1, input2);
    }
}

// Test 대상을 test 하기 위한 class
// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner::class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    var mathApplication: MathApplication = MathApplication()

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    var calcService: CalculatorService? = null

    @Test
    public fun testAdd() {
        //add the behavior of calc service to add two numbers
        Mockito.`when`(calcService?.add(10.0, 20.0)).thenReturn(30.00)

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0)!!, 30.0, 0.toDouble())
    }
}

public class TestRunner {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = JUnitCore.runClasses(MathApplicationTester::class.java)

            for (failure in result.failures) {
                println(failure.toString())
            }

            println(result.wasSuccessful());
        }
    }
}