package jetbrains.kotlin.course.words.generator.results

import jetbrains.kotlin.course.words.generator.team.Team
import jetbrains.kotlin.course.words.generator.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {

    companion object{
        val gameHistory : MutableList<GameResult> = mutableListOf()
    }
    fun saveGameResults(result: GameResult): Unit {
        if (result.isEmpty()) {
            error("Result must not be empty")
        }
        result.forEach {
            if (!TeamService.teamsStorage.containsKey(it.id)) {
                error("All team ids in result must be present in TeamService.teamsStorage")
            }
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> {
        return gameHistory.reversed()
    }
}
