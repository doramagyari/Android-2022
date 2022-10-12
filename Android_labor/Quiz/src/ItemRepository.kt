import java.io.File
import java.util.*

class ItemRepository {

    val items = mutableListOf<Item>()

    init {
        val scanner = Scanner(File("quiz.txt"))
        while (scanner.hasNextLine()){
            var line = scanner.nextLine()
            if (line.isEmpty()) {
                continue
            }
            if (line.toInt() > 0){
                val nrOfAnswers = line.toInt()
                val answersList = mutableListOf<String>()
                var counter = 0
                while (counter < nrOfAnswers){
                    line = scanner.nextLine()
                    answersList.add(line)
                    counter++
                }
                val question = scanner.nextLine()
                val answer = scanner.nextLine().toInt()
                save(Item(question,answersList, answer))
            }
        }

    }

    fun randomItem() : Item{


        return items.random()
    }

    fun save(item: Item){
        items.add(item)
    }

    fun size() : Int {
        return items.size
    }
}