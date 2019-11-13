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
        test("John", "1998", "John98")
        test("Pavel", "-", "Pavel282")
        test("-", "2027", "qwerty2027")
        test("-", "-", "password")
        test("FFFFFFffffFFFFFFFFf", "-", "FFFFFFffffFFFFFFFFf282")
        test("Elon", "1000", "Elon00")
        test("-", "9999", "qwerty9999")
    }

    private fun test(name: String, year: String, password: String) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream("$name\n$year".toByteArray()))
        main()
        Assert.assertEquals("Неправильный ответ для имени \"$name\" и года рождения \"$year\"", password, systemOutRule.log.trim())
    }

}