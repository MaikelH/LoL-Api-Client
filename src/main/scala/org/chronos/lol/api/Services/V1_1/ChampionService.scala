package org.chronos.lol.api.services.V1_1

import scala.concurrent.{ExecutionContext, Future}
import org.chronos.lol.api.services.{ApiKey, Region}
import org.chronos.lol.api.services.V1_1.models.{Summoner, Champion}
import dispatch.{Http, as, url}
import spray.json.JsonParser
import org.chronos.lol.api.services.V1_1.protocol.ChampionProtocol._

/**
 * Created by Maikel on 12/12/13.
 */
object ChampionService  {
  def GetChampions(region: Region.Region)(implicit key: ApiKey, ec: ExecutionContext): Future[Iterable[Champion]] = {
    val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.1/champion?api_key=" + key.getKey()
    val reqUrl = url(urlString)

    for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[Iterable[Champion]]
  }
}
