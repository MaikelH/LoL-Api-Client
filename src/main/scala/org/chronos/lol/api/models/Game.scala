package org.chronos.lol.api.models

import java.sql.Timestamp

/**
 * Created by Maikel on 12/12/13
 */
case class Game(championId: Int,
                createDate: Timestamp,
                createDateStr: String,
                gameId: Long,
                gameMode: String,
                gameType: String,
                level: Int,
                mapId: Int,
                spell1: Int,
                spell2: Int,
                subType: String,
                teamId: Int)
