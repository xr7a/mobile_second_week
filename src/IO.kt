import java.io.File
interface IO {
    fun write(lines: MutableList<String>)
    fun read(): MutableList<String>
}

class ConsoleIO: IO{
    override fun read(): MutableList<String> {
        val lines = mutableListOf<String>()
        while(true){
            val s = readLine()
            if(s != null){
                if("stop" in s) break
                lines.add(s)
            }
        }
        return lines
    }
    override fun write(lines: MutableList<String>) {
        lines.forEach { println(it) }
    }
}

class FileIO: IO {
    override fun read(): MutableList<String> {
        var linesList = mutableListOf<String>()
        File("C:\\Users\\Иван Десятов\\Desktop", "input.txt").useLines { lines -> lines.forEach { linesList.add(it) } }
        return linesList
    }
    override fun write(lines: MutableList<String>) {
        lines.forEach {File("C:\\Users\\Иван Десятов\\Desktop", "output.txt").writeText(it)}
    }
}