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
        test("ЪУЪ", "ЪУЪ УЪ Ъ")
        test("Дратути", "Дратути ратути атути тути ути ти и")
    }

    private fun test(input: String, output: String) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        Assert.assertEquals("Не работает для входных данных: \"$input\"", output, systemOutRule.log.trim())
    }

}