fun main() {
    val numbers = IntArray(42)
    for (i in numbers.indices) numbers[i] = i + 1
    println(numbers.joinToString())
}