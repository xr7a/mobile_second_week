import java.io.File
import java.io.FileNotFoundException

val console : ConsoleIO = ConsoleIO()
val file: FileIO = FileIO()
var base: Int = 10



fun main(){
    println("Выберите тип ввода входных данных: 1) файл 2) консоль")
    val choice = readLine()
    println("Выберите систему счисления выходных данных (по умолчанию 10):")
    val baseChoice = readLine()
    base = baseChoice?.takeIf{it != "" }?.toInt() ?: base
    val console: ConsoleIO
    when(choice){
        "1"->{
            readFromFile()
        }
        "2"->{
            println("Введите входные данные:")
            readFromConsole()
        }
        else -> {
            println("Невалид")
        }

    }
}

fun readFromFile(){
    var results: List<String> = mutableListOf()
    try {
        val lines = file.read()
        results = mainAlgorithm(lines)
        file.write(results)

    }
    catch (e: FileNotFoundException){
        println("Файл с входными данными не был найден. Пожалуйста введите данные в консоль")
        readFromConsole()
    }
}

fun readFromConsole(){
    val lines = console.read()
    val results = mainAlgorithm(lines)
    console.write(results)
}

fun mainAlgorithm(lines: List<String>): List<String>{
    val results = mutableListOf<String>()
    lines.forEach {
        val s = it.split("\\s".toRegex())
        try{
            val firstNumber: Long = s[0].toLong()
            val secondNumber: Long = s[2].toLong()
            when(s[1]){
                "+" -> results.add((firstNumber + secondNumber).toBase(base))
                "-" -> results.add((firstNumber - secondNumber).toBase(base))
                "*" -> results.add((firstNumber * secondNumber).toBase(base))
                "/" -> results.add((firstNumber / secondNumber).toBase(base))
                else -> throw Exception()
            }
        }
        catch (e: NumberFormatException){
            results.add("Неверный формат выражения")
        }
    }
    return results.toList()
}