package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils.TOTAL_NUMBER
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        require(words.size >= TOTAL_NUMBER) {
            "Some error message"
        }
        var generatedWordCard: List<Card> = mutableListOf()
        words = words.shuffled()
        generatedWordCard = words.take(TOTAL_NUMBER).map {word ->
            Card(WordCardData(word), CardState.Front)
        }
        words = words.drop(TOTAL_NUMBER)
        return generatedWordCard
    }
}
