package org.chronos.lol.api.Services

import org.chronos.lol.api.models.{Summoner, Game}
import scala.concurrent.{Future, ExecutionContext}
import dispatch.{Http, as, url}
import spray.json.JsonParser
import RiotJsonProtocol._

/**
 * Created by Maikel on 12/12/13.
 */
object GameService {
  def GetGame(region: Region.Region, SummonerId: Long)(implicit key: ApiKey, ec: ExecutionContext):
    Future[Iterable[Game]] = {
    val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.2/game/by-summoner/" +
                    SummonerId + "/recent?api_key=" + key.getKey()

    val reqUrl = url(urlString)

    for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[Iterable[Game]]
  }
}
