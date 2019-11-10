import org.junit.*
import org.junit.Assert.assertEquals
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
        systemOutRule.clearLog()
        main()
        val ints = systemOutRule.log.trim().split(",").map { it.trim().toInt() }
        assertEquals("Неверная длина массива", 42, ints.size)
        for (i in ints.indices) {
            assertEquals("Неправильный $i элемент", i + 1, ints[i])
        }
    }

}