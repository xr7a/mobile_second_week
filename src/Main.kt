import java.io.File
import ConsoleIO
import FileIO
val console : ConsoleIO = ConsoleIO()
val file: FileIO = FileIO()
fun main(){
    println("Выберите тип ввода входных данных: 1) файл 2) консоль")
    val choice = readLine()
    val console: ConsoleIO
    when(choice){
        "1"->{
            readFromFile()
        }
        "2"->{
            readFromConsole()
        }
        else -> {
            println("Невалид")
        }

    }
}

fun readFromFile(){
    try {
        val lines = file.read()
        val results = mainAlgorithm(lines)
        file.write(results)

    }
    catch (e: Exception){
        println("Файл не был найден. Пожалуйста введите данные в консоль")
        readFromConsole()
    }
}

fun readFromConsole(){
    val lines = console.read()
    val results = mainAlgorithm(lines)
    console.write(results)
}

fun mainAlgorithm(lines: MutableList<String>): MutableList<String>{
    val results = mutableListOf<String>()
    lines.forEach {
        val s = it.split("\\s".toRegex())
        try{
            val firstNumber = s[0].toInt()
            val secondNumber = s[2].toInt()
            when(s[1]){
                "+" -> results.add((firstNumber + secondNumber).toString())
                "-" -> results.add((firstNumber - secondNumber).toString())
                "*" -> results.add((firstNumber * secondNumber).toString())
                "/" -> results.add((firstNumber / secondNumber).toString())

            }
        }
        catch (e: Exception){
            results.add("Неверный формат выражения")
        }
    }
    return results
}