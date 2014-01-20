package org.chronos.lol.api.services.V1_2.models

import java.sql.Timestamp

/**
 * Created by Maikel on 1/3/14
 */
case class RankedStats(summonerId: Long,
                       modifyDate: Timestamp,
                       stats: Seq[ChampionStats])

case class ChampionStats(id: Long,
                         name: Option[String],
                         stats: Map[String, Int])