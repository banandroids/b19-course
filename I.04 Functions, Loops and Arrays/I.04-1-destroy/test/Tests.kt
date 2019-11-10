import junit.framework.Assert.assertEquals
import org.junit.*
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @get:Rule
    val systemOutRule: SystemOutRule = SystemOutRule().enableLog()

    @Test
    fun testSolution() {
        test("AAA", "AAA\nAA\nA")
        test("Hello", "Hello\nHell\nHel\nHe\nH")
        test("Z", "Z")
        test("AbC", "AbC\nAb\nA")
        test("+-+-", "+-+-\n+-+\n+-\n+")
        test("////////////", "////////////\n///////////\n//////////\n/////////\n////////\n///////\n//////\n/////\n////\n///\n//\n/")
    }

    private fun test(input: String, output: String) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        assertEquals("Не работает для входных данных: \"$input\"", output, systemOutRule.logWithNormalizedLineSeparator.trim())
    }

}