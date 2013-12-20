package org.chronos.lol.api.services.V1_1.protocol

import spray.json.{JsValue, RootJsonFormat, DefaultJsonProtocol}
import org.chronos.lol.api.services.V1_1.models.{Champion, Summoner}
import spray.json.lenses.JsonLenses._

/**
 * Created by Maikel on 12/20/13.
 */
object ChampionProtocol extends DefaultJsonProtocol {
  implicit object ChampionFormat extends RootJsonFormat[Champion]
  {
    def write(obj: Champion): JsValue = ???

    def read(json: JsValue): Champion = {
      Champion(json.extract[Boolean]('active),
               json.extract[Int]('attackRank),
               json.extract[Boolean]('botEnabled),
               json.extract[Boolean]('botMmEnabled),
               json.extract[Int]('defenseRank),
               json.extract[Int]('difficultyRank),
               json.extract[Boolean]('freeToPlay),
               json.extract[Int]('id),
               json.extract[Int]('magicRank),
               json.extract[String]('name),
               json.extract[Boolean]('rankedPlayEnabled))
    }
  }

  implicit object ChampionListFormat extends RootJsonFormat[Iterable[Champion]]
  {
    def write(obj: Iterable[Champion]): JsValue = ???

    def read(json: JsValue): Iterable[Champion] = {
      json.extract[Champion]('champions / *)
    }
  }
}
