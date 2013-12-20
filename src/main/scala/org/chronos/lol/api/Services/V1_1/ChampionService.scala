package org.chronos.lol.api.services.V1_1

import scala.concurrent.Future
import org.chronos.lol.api.services.{ApiKey, Region}
import org.chronos.lol.api.services.V1_1.models.Champion

/**
 * Created by Maikel on 12/12/13.
 */
object ChampionService  {
  def GetChampion(id: Int, region: Region.Region)(implicit key: ApiKey): Future[Champion] = ???
}
