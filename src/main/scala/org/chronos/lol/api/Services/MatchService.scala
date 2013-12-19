package org.chronos.lol.api.Services

import org.chronos.lol.api.Services.Region.Region
import org.chronos.lol.api.models.Game

/**
 * Created by Maikel on 12/15/13.
 */
object MatchService {
  def GetRecentMatches(region: Region, id: Int): Seq[Game] = ???
}
