import java.io.File
interface IO {
    fun write(lines: List<String>)
    fun read(): List<String>
}

class ConsoleIO: IO{
    override fun read(): List<String> {
        val lines = mutableListOf<String>()
        while(true){
            val s = readLine()
            if(s != null){
                if("stop" in s) break
                lines.add(s)
            }
        }
        return lines.toList()
    }
    override fun write(lines: List<String>) {
        lines.forEach { println(it) }
    }
}

class FileIO: IO {
    override fun read(): List<String> {
        var linesList = mutableListOf<String>()
        File("C:\\Users\\Иван Десятов\\Desktop", "input.txt").useLines { lines -> lines.forEach { linesList.add(it) } }
        return linesList.toList()
    }
    override fun write(lines: List<String>) {
        lines.forEach {File("C:\\Users\\Иван Десятов\\Desktop", "output.txt").writeText(it)}
    }
}