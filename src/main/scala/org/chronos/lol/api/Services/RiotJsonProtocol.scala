package org.chronos.lol.api.Services

import spray.json._
import org.chronos.lol.api.models.{FellowPlayer, Statistic, Game, Summoner}
import java.sql.Timestamp
import spray.json.lenses.JsonLenses._

/**
 * Created by Maikel on 12/15/13
 */
object RiotJsonProtocol extends DefaultJsonProtocol {
  implicit object SummonerFormat extends RootJsonFormat[Summoner] {
    def write(obj: Summoner): JsValue = ???

    def read(json: JsValue): Summoner = {
      json.asJsObject.getFields("id", "name", "profileIconId", "summonerLevel", "revisionDate", "revisionDateStr")
      match {
        case Seq(JsNumber(id), JsString(name), JsNumber(iconId), JsNumber(level),
                 JsNumber(revDate), JsString(revDateStr)) => new Summoner(id.intValue(), name, iconId.intValue(), new Timestamp(revDate.longValue()),
                                                                  revDateStr, level.intValue() )
        case _ => throw new DeserializationException("Summoner expected")
      }
    }
  }

  implicit object StatisticFormat extends RootJsonFormat[Statistic] {
    def write(obj: Statistic): JsValue = ???

    def read(json: JsValue): Statistic = {
      Statistic(json.extract[Int]('id),
                json.extract[String]('name),
                json.extract[Int]('value))
    }
  }

  implicit object FellowPlayerFormat extends RootJsonFormat[FellowPlayer] {
    def write(obj: FellowPlayer): JsValue = ???

    def read(json: JsValue): FellowPlayer = {
      FellowPlayer(json.extract[Long]('summonerId),
                   json.extract[Int]('teamId),
                   json.extract[Int]('championId))
    }
  }

  implicit object GameFormat extends RootJsonFormat[Game]{
    def write(obj: Game): JsValue = ???

    def read(json: JsValue): Game = {
      val statisticLens = 'statistics / *
      val fellowPlayerLens = 'fellowPlayers / *

      // Extract the statistics and fellowplayers
      val statistics = json.extract[Statistic](statisticLens)
      val fellowPlayers = json.extract[FellowPlayer](fellowPlayerLens)

      Game(json.extract[Int]('championId),
           new Timestamp(json.extract[Long]('createDate)),
           json.extract[Int]('gameId),
           json.extract[String]('gameMode),
           json.extract[String]('gameType),
           json.extract[Int]('level),
           json.extract[Int]('mapId),
           json.extract[Int]('spell1),
           json.extract[Int]('spell1),
           json.extract[String]('subType),
           json.extract[Int]('teamId),
           fellowPlayers,
           statistics)
    }
  }

  implicit object GameListFormat extends RootJsonFormat[Iterable[Game]]{
    def write(obj: Iterable[Game]): JsValue = ???

    def read(json: JsValue): Iterable[Game] = {
      val gameLense = 'games / *
      json.extract[Game](gameLense)
    }
  }
}
