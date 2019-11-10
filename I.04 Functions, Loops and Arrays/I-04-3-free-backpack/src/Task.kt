fun main() {
    val n = readLine()!!.toInt()
    val backpack = Array(n) { "" }
    for (i in 0 until n) {
        backpack[i] = readLine()!!
    }
    var noEmpty = true
    for (i in backpack.indices) {
        if (backpack[i].isEmpty()) {
            noEmpty = false
            print("${i + 1} ")
        }
    }
    if (noEmpty) println('-')
}