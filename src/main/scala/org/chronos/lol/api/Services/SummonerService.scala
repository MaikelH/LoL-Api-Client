package org.chronos.lol.api.Services

import org.chronos.lol.api.Services.Region.Region
import org.chronos.lol.api.models.Summoner
import scala.concurrent._
import dispatch.{url, Http, host, as}
import spray.json._
import RiotJsonProtocol._
import org.chronos.lol.api.models.Summoner
import spray.json.lenses.JsonLenses._

/**
 * Created by Maikel on 12/15/13
 */
object SummonerService {

  def GetSummoner(region: Region, id: Int)(implicit key: ApiKey, ec: ExecutionContext): Future[Summoner] = {

      val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.1/summoner/" + id + "?api_key=" + key.getKey()
      val reqUrl = url(urlString)

      for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[Summoner]
  }

  def GetSummoner(region: Region, name: String)(implicit key: ApiKey, ec: ExecutionContext): Future[Summoner] = {
    val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.1/summoner/by-name/" + name + "?api_key=" + key.getKey()
    val reqUrl = url(urlString)

    for(response <- Http(reqUrl OK as.String)) yield JsonParser(response).convertTo[Summoner]
  }

  def GetSummonerNames(region: Region, ids: Iterable[Long])(implicit key: ApiKey, ec: ExecutionContext): Future[Map[Long, String]] = {
    // Convert the Iterable of ids to a comma separated string.
    def commaSeparatedIds(seq: Iterable[Long]): String = seq match {
      case head :: tail => tail.foldLeft(head.toString)((a,b) => a + "," + b)
      case Nil => ""
    }

    // Converted the return json to a Map[Int, String]
    // TODO: This is not very nicely done, see if can be done better
    def jsonToMap(json: JsValue): Map[Long, String] = {
      val AllNames = 'summoners / * / 'name
      val AllId = 'summoners / * / 'id

      val ids = json.extract[Long](AllId)
      val names = json.extract[String](AllNames)
      val map : Map[Long, String] = ids.zip(names).toMap

      map
    }

    val urlString = "https://prod.api.pvp.net/api/lol/" + region.toString + "/v1.1/summoner/" +
                                                          commaSeparatedIds(ids) + "/name?api_key=" + key.getKey()

    for(response <- Http(url(urlString) OK as.String)) yield jsonToMap(JsonParser(response))
  }
}
