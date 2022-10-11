class ItemService(val itemRepository: ItemRepository)
{
    fun selectRandomItems(numberOfQuestions : Int) : List<Item>{
        val questions = mutableListOf<Item>()

        if(numberOfQuestions > itemRepository.size()){
            return questions
        }

        while (questions.size != numberOfQuestions){
            val item = this.itemRepository.randomItem()
            if (!questions.contains(item)){
                questions.add(item)
            }
        }

        return questions

    }

}