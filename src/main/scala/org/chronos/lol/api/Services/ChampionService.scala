package org.chronos.lol.api.Services
import scala.concurrent.Future
import org.chronos.lol.api.models.Champion

/**
 * Created by Maikel on 12/12/13.
 */
object ChampionService  {
  def GetChampion(id: Int, region: Region.Region)(implicit key: ApiKey): Future[Champion] = ???
}
