fun main() {
    var s = readLine()!!
    repeat(s.length) {
        s = s.substring(1)
        println(s)
    }
}