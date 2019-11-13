import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val backpack = getRandomBackpack(1000)
        Assert.assertTrue("Неправильное количество ячеек в рюкзаке", 1000 == backpack.size)
        val map: MutableMap<String, Int> = mutableMapOf("Bread" to 0, "Sword" to 0, "Book" to 0, "Potion" to 0)
        for (thing in backpack) {
            Assert.assertTrue("В рюкзаке лежит $thing, хотя должно лежать только \"Bread\", или \"Sword\", или \"Book\", или \"Potion\"", thing in arrayOf("Bread", "Sword", "Book", "Potion"))
            map[thing] = map[thing]!! + 1
        }
        for ((key, value) in map) {
            Assert.assertTrue("В рюкзак не добавляется $key", value != 0)
        }
    }
}