package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    fun saveGameResults(result: GameResult) {
        if (result.isEmpty()) {
            error("Result must be not empty")
        }
        if (!result.any {TeamService.teamsStorage.containsKey(it.id) }) {
            error("All team ids from the result must be present in the TeamService.teamsStorage")
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory

    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }
}
