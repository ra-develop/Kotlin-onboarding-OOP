package jetbrains.kotlin.course.codenames.utils

import jetbrains.kotlin.course.codenames.keyCard.KeyCard
import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
import jetbrains.kotlin.course.codenames.keyCard.KeyCardType

fun KeyCard.toJsKeyCard() = this.cells.map { it.toJsKeyCardType() }

private fun KeyCardCell.toJsKeyCardType() = when (type) {
    KeyCardType.Pink -> 0
    KeyCardType.Violet -> 1
    KeyCardType.Gray -> 2
    KeyCardType.Black -> 3
}

object ConvertersUtils {
    val cardsFactory = IdentifierFactory()
}
