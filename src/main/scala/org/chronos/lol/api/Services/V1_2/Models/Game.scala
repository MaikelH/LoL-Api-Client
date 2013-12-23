package org.chronos.lol.api.services.V1_2.models

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
                fellowPlayers: Option[Seq[FellowPlayer]],
                statistics: Seq[Statistic])

case class FellowPlayer(summonerId: Long, teamId: Int, championId: Int)

case class Statistic(id: Int, name: String, value: Int)

object QueueType extends Enumeration {
  type QueueType          = Value

  val NORMAL_5v5_BLIND    = Value(2, "Normal 5v5 Blind Pick")
  val RANKED_SOLO_5v5     = Value(4, "Ranked Solo 5v5")
  val COOP_VS_AI_5v5      = Value(7, "Coop vs AI 5v5")
  val NORMAL_3v3          = Value(8, "Normal 3v3")
  val NORMAL_5v5_DRAFT    = Value(14, "Normal 3v3")
  val DOMINION_5v5_BLIND  = Value(16, "Normal 3v3")
  val DOMINION_5v5_DRAFT  = Value(17, "Normal 3v3")
  val DOMINION_COOP_VS_AI = Value(25, "Normal 3v3")
  val RANKED_TEAM_3VS3    = Value(41, "Normal 3v3")
  val RANKED_TEAM_5VS5    = Value(42, "Normal 3v3")
  val TWISTED_COOP_VS_AI  = Value(52, "Normal 3v3")
  val ARAM                = Value(65, "Normal 3v3")
  val ARAM_COOP_VS_AI     = Value(67, "Normal 3v3")
  val SHOWDOWN_1VS1       = Value(72, "Normal 3v3")
  val SHOWDOWN_2VS2       = Value(73, "Normal 3v3")
}

