package org.chronos.lol.api.services.V1_2.protocol

import spray.json.{DefaultJsonProtocol, JsValue, RootJsonFormat}
import java.sql.Timestamp
import spray.json.lenses.JsonLenses._
import org.chronos.lol.api.services.V1_2.models.{Statistic, FellowPlayer, Game}

/**
 * Created by Maikel on 12/20/13.
 */
object GameServiceProtocol extends DefaultJsonProtocol {
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

      // Extract the statistics and fellowplayers
      val statistics = json.extract[Statistic](statisticLens)

      // Fellow players is not always there so make it a option
      val fellowPlayers  = json.extract[JsValue]('fellowPlayers.?) match {
        case Some(x) => Some(json.extract[FellowPlayer]('fellowPlayers / *))
        case None => None
      }

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
