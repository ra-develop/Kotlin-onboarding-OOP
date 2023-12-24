package jetbrains.kotlin.course.card.trainer.util

import card.trainer.JsCardTrainerModel
import jetbrains.kotlin.course.card.trainer.card.Card

fun Card.toJsCard(): JsCardTrainerModel = JsCardTrainerModel(front.capital, back.country)
