import org.junit.*
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import java.io.ByteArrayInputStream

class Test {
    @get:Rule
    val systemOutRule: SystemOutRule = SystemOutRule().enableLog()

    @Test
    fun testSolution() {
        test(1, arrayOf("#"))
        test(2, arrayOf(" #", "###"))
        test(3, arrayOf("  #", " ###", "#####"))
        test(5, generate(5))
        test(10, generate(10))
    }

    private fun test(size: Int, output: Array<String>) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(size.toString().toByteArray()))
        main()
        val result: Array<String> = systemOutRule.logWithNormalizedLineSeparator.trimEnd().split("\n").map { it.trimEnd() }.toTypedArray()
        Assert.assertArrayEquals("Неправильный ответ для высоты = $size", output, result)
    }

    private fun generate(size: Int) = Array<String>(size) { i -> " ".repeat(size - i - 1) + "#".repeat(i * 2 + 1)}

}