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
        test("000000", true)
        test("000001", false)
        test("123321", true)
        test("576675", true)
        test("782179", true)
        test("912920", false)
        test("999998", false)
        test("999999", true)
        test("066660", false)
        test("660066", true)
        test("666666", false)
    }

    private fun test(ticket: String, lucky: Boolean) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(ticket.toByteArray()))
        main()
        Assert.assertEquals("Не работает для билета #$ticket", lucky.toString(), systemOutRule.log.trim())
    }

}