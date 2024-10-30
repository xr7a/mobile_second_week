fun Long.toBase(base: Int): String {
    require(base in 2..36){"Система счисления должна находиться в промежутке от 2 до 36 "}
    if(this == 0L) return "0"
    var number = this
    val result = StringBuilder()
    val digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    while(number != 0L){
        var remainder = (number % base).toInt()
        result.append(digits[remainder])
        number /= base
    }

    return result.reverse().toString()
}