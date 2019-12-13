data class Film(
        val name: String,
        val rating: Float
)

fun search(films: List<Film>, x: String, y: Float): List<Film> {
    // место для вашего кода
}

fun main() {
    val testFilms = listOf(Film("Назад в будущее", 8.626f),
            Film("Звёздные войны: Эпизод 4 – Новая надежда", 8.108f),
            Film("Джокер", 8.165f),
            Film("Форрест Гамп", 9.013f),
            Film("Ёлки", 6.875f),
            Film("Ёлки 5", 4.806f))
    println(search(testFilms, "ёлки", 6f))
}