import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        test("Маргарита", makeMargarita(), true, arrayOf("моцарелла"), 0, true)
        test("Пепперони", makePepperoni(), true, arrayOf("моцарелла"), 7, false)
        test("Четыре сыра", makeQuattroFormaggio(), false, arrayOf("моцарелла", "дорблю", "пармезан", "эмменталь"), 0, false)
    }

    fun test(name: String, pizza: Pizza, tomatoSauce: Boolean, cheese: Array<String>, pepperoni: Int, basil: Boolean) {
        Assert.assertEquals("Шеф-повар не доволен: в пицце $name что-то не так с томатным соусом", tomatoSauce, pizza.tomatoSauce)
        Assert.assertEquals("Шеф-повар не доволен: в пицце $name что-то не так с количеством используемых сыров", cheese.size, pizza.cheese.size)
        for (c in cheese) {
            Assert.assertEquals("Шеф-повар не доволен: в пицце $name нет сыра $c", true, pizza.cheese.contains(c))
        }
        Assert.assertEquals("Шеф-повар не доволен: в пицце $name что-то не так с колбасой пепперони", pepperoni, pizza.pepperoni)
        Assert.assertEquals("Шеф-повар не доволен: в пицце $name что-то не так с базиликом", basil, pizza.basil)
    }
}