fun main() {
    val size = readLine()!!.toInt()
    for (i in 0 until size) {
        repeat(size - i - 1) { print(" ") }
        repeat(i * 2 + 1) { print("#") }
        println()
    }
}