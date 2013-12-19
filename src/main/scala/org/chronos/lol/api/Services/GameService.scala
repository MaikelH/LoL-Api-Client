package org.chronos.lol.api.Services

import org.chronos.lol.api.models.Game

/**
 * Created by Maikel on 12/12/13.
 */
object GameService {
  def GetGame(region: Region.Region, id: Long)(implicit key: ApiKey): Game = ???
}
