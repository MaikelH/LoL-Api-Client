package org.chronos.lol.api.services.V2_1.protocol

import spray.json._
import org.chronos.lol.api.services.V2_1.models.{MiniSeries, LeagueItem, League}
import spray.json.lenses.JsonLenses._
import java.sql.Timestamp

/**
 * Created by Maikel on 12/21/13
 */
object LeagueProtocol extends DefaultJsonProtocol {

  implicit object MiniSeriesFormat extends RootJsonFormat[MiniSeries]{
    def write(obj: MiniSeries): JsValue = ???

    def read(json: JsValue): MiniSeries = {
      MiniSeries(json.extract[String]('progress),
                 json.extract[Int]('target),
                 json.extract[Int]('losses),
                 json.extract[Long]('timeLeftToPlayMillis),
                 json.extract[Int]('wins))
    }
  }

  implicit object LeagueItemFormat extends RootJsonFormat[LeagueItem]{
    def write(obj: LeagueItem): JsValue = ???

    def read(json: JsValue): LeagueItem = {
      LeagueItem(json.extract[Boolean]('isFreshBlood),
                 json.extract[Boolean]('isHotStreak),
                 json.extract[Boolean]('isInactive),
                 json.extract[Boolean]('isVeteran),
                 new Timestamp(json.extract[Long]('lastPlayed)),
                 json.extract[String]('leagueName),
                 json.extract[Int]('leaguePoints),
                 json.extract[MiniSeries]('miniSeries.?),
                 json.extract[String]('playerOrTeamId),
                 json.extract[String]('playerOrTeamName),
                 json.extract[String]('queueType),
                 json.extract[String]('rank),
                 json.extract[String]('tier),
                 json.extract[Int]('wins),
                 json.extract[Int]('losses),
                 json.extract[Long]('timeUntilDecay)
      )
    }
  }

  implicit object LeagueFormat extends RootJsonFormat[League]{
    def write(obj: League): JsValue = ???

    def read(json: JsValue): League = {
      val leagueEntries = json.extract[LeagueItem]('entries / *)

      League(json.extract[String]('name),
             json.extract[String]('queue),
             json.extract[String]('tier),
             leagueEntries)
    }
  }

  implicit object LeagueMapFormat extends RootJsonFormat[Map[String, League]]{
    def write(obj: Map[String, League]): JsValue = ???

    def read(json: JsValue): Map[String, League] = {
      json match {
        case JsObject(objects) => objects.map(a => a._1 -> a._2.convertTo[League])
        case _ => throw new DeserializationException("List of leagues expected.")
      }
    }
  }
}
