package org.chronos.lol.api.services.V2_2

import org.chronos.lol.api.services.Region.Region
import scala.concurrent.{ExecutionContext, Future}
import dispatch.{Http, as, url}
import spray.json.JsonParser
import org.chronos.lol.api.services.ApiKey
import org.chronos.lol.api.services.V2_2.protocol.LeagueProtocol._
import org.chronos.lol.api.services.V2_2.models.League

/**
 * Created by Maikel on 12/20/13
 */
object LeagueService {
  def GetLeagueData(region: Region, id: Long)(implicit key: ApiKey, ec: ExecutionContext) : Future[Map[String, League]] = {
    val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v2.2/league/by-summoner/" + id + "?api_key=" + key.getKey()

    val reqUrl = url(urlString)

    for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[Map[String, League]]
  }
}
