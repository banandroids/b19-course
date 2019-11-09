fun main() {
    val name = readLine()!!
    val year = readLine()!!
    if (name == "-") {
        if (year == "-") {
            println("password")
        } else {
            println("qwerty$year")
        }
    } else if (year == "-") {
        println("${name}282")
    } else {
        println("$name${year.substring(2)}")
    }
}