fun main() {
    var s = readLine()!!
    println(s)
    repeat(s.length) {
        s = s.substring(0, s.length - 1)
        println(s)
    }
}