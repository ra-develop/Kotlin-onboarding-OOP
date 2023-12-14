package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {

    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teamsForOneRound = List(teamsNumber) {
            Team(identifierFactory.uniqueIdentifier())
        }
        teamsForOneRound.forEach {
            teamsStorage[it.id] = it
        }
        return teamsForOneRound
    }
}
