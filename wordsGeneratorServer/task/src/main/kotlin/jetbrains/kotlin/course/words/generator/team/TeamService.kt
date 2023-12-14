package jetbrains.kotlin.course.words.generator.team

import org.springframework.stereotype.Service

@Service
class TeamService {
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val generatedTeams = List(teamsNumber) {
            Team()
        }
        generatedTeams.forEach { team -> teamsStorage.put(team.id, team) }
        return generatedTeams
    }

    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }
}
