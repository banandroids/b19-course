fun main() {
    var s = readLine()!!
    s = s.toLowerCase().replace(" ", "")
    println(s.reversed() == s)
}