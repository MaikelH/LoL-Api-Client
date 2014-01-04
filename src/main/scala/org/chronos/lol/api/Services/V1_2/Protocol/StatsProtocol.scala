package org.chronos.lol.api.services.V1_2.protocol

import spray.json.{JsValue, RootJsonFormat}
import org.chronos.lol.api.services.V1_2.models.{RankedStats, ChampionStats}
import spray.json.lenses.JsonLenses._
import java.sql.Timestamp
import spray.json.DefaultJsonProtocol._

/**
 * Created by Maikel on 1/3/14.
 */
object StatsProtocol {

  implicit object ChampionStatFormat extends RootJsonFormat[ChampionStats] {
    def write(obj: ChampionStats): JsValue = ???

    def read(json: JsValue): ChampionStats = {
      val stats = json.extract[Map[String, Int]]('stats)

      ChampionStats(json.extract[Int]('id),
        json.extract[String]('name),
        stats)
    }
  }

  implicit object RankedStatsFormat extends RootJsonFormat[RankedStats]
  {
    def write(obj: RankedStats): JsValue = ???

    def read(json: JsValue): RankedStats = {
      val stats  = json.extract[ChampionStats]('champions / *)

      RankedStats(json.extract[Long]('summonerId),
                  new Timestamp(json.extract[Long]('modifyDate)),
                  stats)
    }
  }
}
