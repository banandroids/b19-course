fun main() {
    val s = readLine()!!
    val sumEquals = (s[0].toInt() + s[1].toInt() + s[2].toInt()
            == s[3].toInt() + s[4].toInt() + s[5].toInt())
    println(sumEquals && !s.contains("666"))
}