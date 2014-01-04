package org.chronos.lol.api.services.V1_2.models

import java.sql.Timestamp

/**
 * Created by Maikel on 1/4/14.
 */
case class PlayerStatsList(summonerId: Long,
                           summaries: Seq[PlayerStats])

case class PlayerStats(losses: Int,
                       modififyDate: Timestamp,
                       statSummaryType: String,
                       wins: Int,
                       stats: Map[String, Int])


