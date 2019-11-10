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
        test("2\nSword\nBread", intArrayOf())
        test("5\n\n\nSword\n\n\n", intArrayOf(1, 2, 4, 5))
    }

    private fun test(input: String, output: IntArray) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        val result = systemOutRule.log.trim()
        Assert.assertArrayEquals(output, if (result.isBlank()) intArrayOf() else result.split(" ").map { it.trim().toInt() }.toIntArray())
    }

}