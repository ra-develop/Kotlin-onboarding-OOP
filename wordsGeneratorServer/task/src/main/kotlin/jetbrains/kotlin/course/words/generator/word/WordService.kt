package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    fun generateNextWord(): Word {
        if (words.isEmpty()) {
            error("Words is empty")
        }
        val generatedWordString = words.first()
        words.removeAt(0)
        return Word(generatedWordString)
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean {
        if (newWord.isEmpty()) {
            return false
        }

        newWord.forEach {
            if (!keyWord.contains(it)) {
                return@isValidWord false
            }
        }
        val newWordBySymbols = newWord.groupingBy { it }.eachCount()

        val keyWordBySymbols = keyWord.groupingBy { it }.eachCount()

        newWordBySymbols.forEach {
            if (!keyWordBySymbols.containsKey(it.key)) {
                return@isValidWord false
            }
            if (it.value > keyWordBySymbols[it.key]!!) {
                return@isValidWord false            }
        }
        return  true
    }

    fun isNewWord(keyWord: String, newWord: String): Boolean {
        if (!previousWords.containsKey(keyWord)) {
            previousWords.putIfAbsent(keyWord, mutableListOf(Word(newWord)))
            return true
        } else {
            if (previousWords[keyWord]!!.contains(Word(newWord))) {
                return false
            } else {
                previousWords[keyWord]!!.add(Word(newWord))
                return true
            }
        }
    }

    companion object {
        val numberOfWords: Int = words.size
        private val previousWords: MutableMap<String, MutableList<Word>> = mutableMapOf()
    }
}
