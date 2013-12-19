package org.chronos.lol.api.Services

import spray.json._
import org.chronos.lol.api.models.Summoner
import java.sql.Timestamp

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
}
