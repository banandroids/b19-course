fun main() {
    val n = readLine()!!.toInt()
    val backpack = Array(n) { "" }
    for (i in 0 until n) {
        backpack[i] = readLine()!!
    }
    for (i in backpack.indices) {
        if (backpack[i].isEmpty()) {
            print("${i + 1} ")
        }
    }
}