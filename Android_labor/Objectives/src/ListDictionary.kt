import java.io.File

object ListDictionary : IDictionary {

    val words = mutableListOf<String>()

    init {
        //beolvasas, hozzaadas
        File(IDictionary.FILE_NAME).forEachLine { (add(it)) }
    }

    override fun add(word: String) : Boolean {
        if(!find(word)) {
            return words.add(word)
        }
        return false
    }

    override fun find(word: String): Boolean {
        if(words.contains(word)){
            return true
        }
        return false
    }

    override fun size(): Int {
        return words.size
    }
}