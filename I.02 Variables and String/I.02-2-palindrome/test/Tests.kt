import org.junit.*
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @get:Rule
    val systemOutRule = SystemOutRule().enableLog()

    @Test
    fun testSolution() {
        test("Ahaha", true)
        test("ahaho", false)
        test("Anna", true)
        test("Amore           Roma", true)
        test("Was it a car or a cat I saw", true)
        test("AAAaaaaAAAAaaaaaAAAA", true)
        test("AZ", false)
        test("Ahahaahahahahahaahaa", false)
        test("palindrome", false)
    }

    private fun test(input: String, output: Boolean) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        Assert.assertEquals("Не работает для входных данных: \"$input\"", output.toString(), systemOutRule.log.trim())
    }

}