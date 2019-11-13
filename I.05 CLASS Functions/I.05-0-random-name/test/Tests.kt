import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val map: MutableMap<String, Int> = mutableMapOf("Elon" to 0, "John" to 0, "Ivan" to 0)
        for (i in 0..1000) {
            val name = getRandomName()
            Assert.assertTrue("Метод вернул $name, хотя должен отдавать только \"Elon\", или \"John\", или \"Ivan\"", name in arrayOf("Elon", "John", "Ivan"))
            map[name] = map[name]!! + 1
        }
        for ((key, value) in map) {
            Assert.assertTrue("Метод не возвращает имя $key", value != 0)
        }
    }
}