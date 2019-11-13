import kotlin.random.Random.Default.nextInt

fun getRandomBackpack(size: Int): Array<String> {
    val backpack = Array(size) { "" }
    for (i in backpack.indices) {
        backpack[i] = arrayOf("Bread", "Sword", "Book", "Potion")[nextInt(0, 4)]
    }
    return backpack
}