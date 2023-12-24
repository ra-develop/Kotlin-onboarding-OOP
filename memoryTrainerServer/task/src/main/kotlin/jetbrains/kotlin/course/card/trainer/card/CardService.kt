package jetbrains.kotlin.course.card.trainer.card

import jetbrains.kotlin.course.card.trainer.util.countries
import org.springframework.stereotype.Service

@Service
class CardService {
    fun getNextCard(): Card {
        require(cards.isNotEmpty()) { "Some error"}
        return cards.removeFirst()
    }

    fun startNewGame(): Card {
        cards = generateNewCardsSequence()
        return getNextCard()
    }

    companion object {
        val randomCardGenerator = CardSequenceGenerator {
            countries.map { (capital, country) ->
                Card(Front(capital), Back(country))
            }.shuffled()
        }

        var cards = generateNewCardsSequence()
        private fun generateNewCardsSequence(): MutableList<Card> = randomCardGenerator.generateCards().toMutableList()
    }
}
