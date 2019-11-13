import org.junit.*
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets.UTF_8

class Test {
    @get:Rule
    val systemOutRule = SystemOutRule().enableLog()

    @Test
    fun testSolution() {
        main()
        val result = systemOutRule.log.trim()
        Assert.assertEquals("Нужно вывести в консоль \"aaaaaaaaaaaa\" (это английское а), а не \"${result}\"", "aaaaaaaaaaaa", result)
    }
}