import kotlin.random.Random.Default.nextInt

fun getRandomName(): String {
    return arrayOf("Elon", "John", "Ivan")[nextInt(0, 3)]
}