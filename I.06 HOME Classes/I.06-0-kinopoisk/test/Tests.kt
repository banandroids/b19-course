import org.junit.Assert
import org.junit.Test
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

class Test {
    @Test fun testSolution() {
        val parameters = Film::class.primaryConstructor!!.parameters
        Assert.assertEquals("Неправильное количество свойств", 5, parameters.size)
        val film = Film()
        val names = arrayOf("name", "year", "rating", "reviews", "favourite")
        val types = arrayOf("String?", "Int", "Float", "Array<String>", "Boolean")
        val values = arrayOf("null", "0", "0.0", "", "false")
        for (i in 0..4) {
            Assert.assertEquals("Неправильное имя у параметра $i", names[i], parameters[i].name)
            Assert.assertEquals("Неправильный тип у параметра ${names[i]}", types[i], parameters[i].type.toString().replace("kotlin.", ""))
            val property = Film::class.memberProperties.find { it.name == names[i] }!!.get(film)
            if (i == 3) {
                property as Array<String>
                Assert.assertEquals("Неправильное значение по умолчанию у параметра ${names[i]} (размер массива)", 0, property.size)
            } else {
                Assert.assertEquals("Неправильное значение по умолчанию у параметра ${names[i]}", values[i], property.toString())
            }
        }
    }
}