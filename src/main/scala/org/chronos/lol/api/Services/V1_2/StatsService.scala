package org.chronos.lol.api.services.V1_2

import org.chronos.lol.api.services.{Region, ApiKey}
import scala.concurrent.{Future, ExecutionContext}
import org.chronos.lol.api.services.V1_2.models.RankedStats
import dispatch.{Http, as, url}
import spray.json.JsonParser
import org.chronos.lol.api.services.V1_2.protocol.StatsProtocol._

/**
 * Created by Maikel on 1/3/14
 */
object StatsService {

  def GetRankedStats(region: Region.Region, SummonerId: Long)(implicit key: ApiKey, ec: ExecutionContext): Future[RankedStats] = {
    val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.2/stats/by-summoner/" +
      SummonerId + "/ranked?api_key=" + key.getKey()

    val reqUrl = url(urlString)

    for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[RankedStats]
  }

  def GetSummaryStats(region: Region.Region, SummonerId: Long)(implicit key: ApiKey, ec: ExecutionContext) ={}
}
