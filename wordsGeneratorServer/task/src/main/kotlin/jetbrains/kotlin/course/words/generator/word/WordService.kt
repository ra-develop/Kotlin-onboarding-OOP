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

    fun isValidWord(keyWord: String, newWord: String): Boolean = TODO("Not implemented yet")

    fun isNewWord(keyWord: String, newWord: String): Boolean = TODO("Not implemented yet")

    companion object {
        val numberOfWords: Int = words.size
    }
}
