import org.junit.Assert
import org.junit.Test

class Test {

    private val films = listOf(Film("Назад в будущее", 8.626f),
            Film("Звёздные войны: Эпизод 4 – Новая надежда", 8.108f),
            Film("Джокер", 8.165f),
            Film("Форрест Гамп", 9.013f),
            Film("Ёлки", 6.875f),
            Film("Ёлки 5", 4.806f))

    @Test fun testSolution() {
        test(listOf(films[4]), "ёлки", 6.5f)
        test(listOf(films[4]), "ёлки", 4.807f)
        test(listOf(films[4], films[5]), "ёлки", 4.806f)
        test(listOf(films[0], films[1], films[2], films[3]), "е", 0f)
        test(listOf(films[3]), "е", 9.013f)
        test(listOf(), "e", 9.014f)
    }

    private fun test(expected: List<Film>, x: String, y: Float) {
        Assert.assertEquals("Неправильный ответ для подстроки поиска \"$x\" и минимального рейтинга \"$y\"", expected, search(films, x, y))
    }
}