import java.io.File

class ItemRepository {

 val items =  mutableListOf<Item>()

    init {
        var isNewQuestion = true
        var numberOfLinesPerQuestion = 0

        var lines = File("question.txt").readLines()
        var i = 0
        while ( i < lines.size){
            val numberOfAnswers = lines[i++].toInt()
            val question = lines[i++]
            val correct = lines[i++].toInt()
            val answers = mutableListOf<String>()
            for(answer in (i+3)..(i+numberOfAnswers-1)){
                answers.add(lines[answer])
            }
            i+= numberOfAnswers + 1
            val item = Item(question, correct, answers)
        }

    }

    fun randomItem() : Item{
        val index = (1.. items.size- 1).random()

        return items[index]
    }

    fun save(item: Item){
        items.add(item)
    }

    fun size() : Int {
        return items.size
    }
}