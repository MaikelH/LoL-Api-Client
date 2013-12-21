package org.chronos.lol.api.services.V2_1.models

import java.sql.Timestamp


/**
 * Created by Maikel on 12/20/13
 */
case class League(name: String, queue: String, tier: String, LeagueEntries: Seq[LeagueItem])

case class LeagueItem(isFreshBlood: Boolean,
                      isHotStreak: Boolean,
                      isInActive: Boolean,
                      isVeteran: Boolean,
                      lastPlayed: Timestamp,
                      leagueName: String,
                      leaguePoints: Int,
                      miniSeries: Option[MiniSeries],
                      playerOrTeamId: String,
                      playerOrTeamName: String,
                      queueType: String,
                      rank: String,
                      tier: String,
                      wins: Int,
                      losses: Int,
                      timeUntilDecay: Long)

case class MiniSeries(progress: String, target: Int, losses: Int, timeLeftMillis: Long, wins: Int)
