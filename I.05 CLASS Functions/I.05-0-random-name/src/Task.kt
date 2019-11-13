import kotlin.random.Random.Default.nextInt

fun getRandomName() = arrayOf("Elon", "John", "Ivan")[nextInt(0, 3)]