fun main(){
    exercise1()
//    println("Magyari Dora".monogram())
}

//fun String.monogram() = this.split(" ").joinToString(""){ it.first().toUpperCase() }

fun exercise1() {
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST_)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}


