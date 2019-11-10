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
        test("3\nSword\n\nBread", intArrayOf(2))
        test("2\nSword\nBread")
        test("5\n\n\nSword\n\n\n", intArrayOf(1, 2, 4, 5))
        test("5\nSword\nSword\nSword\nSword\nSword")
        test("10\nBread\nBow\n\nSword\n\nBread\n\n\n\nSword", intArrayOf(3,5,7,8,9))
        test("6\n\n\n\n\n\n\n", intArrayOf(1, 2, 3, 4, 5, 6))
        test("5\nSword\n\n\n\nBread\n", intArrayOf(2, 3, 4))
    }

    private fun test(input: String) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        assertEquals("Неправильный ответ для входных данных:\n$input", "-", systemOutRule.log.trim())
    }

    private fun test(input: String, output: IntArray) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        val result = systemOutRule.log.trim()
        Assert.assertArrayEquals("Неправильный ответ для входных данных:\n$input\n", output, if (result.isBlank()) intArrayOf() else result.split(" ").map { it.trim().toInt() }.toIntArray())
    }

}