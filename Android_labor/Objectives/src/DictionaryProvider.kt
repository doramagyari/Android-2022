class DictionaryProvider {

    companion object {
        fun createDictionary(type: DictionaryType): IDictionary {
            when (type) {
                DictionaryType.ARRAY_LIST_ -> return ListDictionary
                else -> {
                    return ListDictionary
                }
            }
        }
    }
}