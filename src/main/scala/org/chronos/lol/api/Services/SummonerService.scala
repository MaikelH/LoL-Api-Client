package org.chronos.lol.api.Services

import org.chronos.lol.api.Services.Region.Region
import org.chronos.lol.api.models.Summoner
import scala.concurrent._
import dispatch.{url, Http, host, as}
import spray.json._
import RiotJsonProtocol._

/**
 * Created by Maikel on 12/15/13
 */
object SummonerService {

  def GetSummoner(region: Region, id: Int)(implicit key: ApiKey, ec: ExecutionContext): Future[Summoner] = {

      val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.1/summoner/" + id + "?api_key=" + key.getKey()
      val reqUrl = url(urlString)

      println(url.toString())

      for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[Summoner]
  }

  def GetSummoner(region: Region, name: String)(implicit key: ApiKey): Summoner = ???
  def GetSummonerNames(region: Region, ids: Iterable[Int])(implicit key: ApiKey): Map[Int, Summoner] = ???
}
