package org.chronos.lol.api.models

import java.sql.Timestamp

/**
 * Created by Maikel on 12/12/13
 */
case class Game(championId: Int,
                createDate: Timestamp,
                gameId: Long,
                gameMode: String,
                gameType: String,
                level: Int,
                mapId: Int,
                spell1: Int,
                spell2: Int,
                subType: String,
                teamId: Int,
                fellowPlayers: Seq[FellowPlayer],
                statistics: Seq[Statistic])

case class FellowPlayer(summonerId: Long, teamId: Int, championId: Int)

case class Statistic(id: Int, name: String, value: Int)

