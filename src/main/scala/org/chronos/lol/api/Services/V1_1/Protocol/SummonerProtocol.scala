package org.chronos.lol.api.services.V1_1.protocol

import spray.json._
import java.sql.Timestamp
import org.chronos.lol.api.services.V1_1.models.Summoner
import org.chronos.lol.api.services.V1_1.models.Summoner

/**
 * Created by Maikel on 12/20/13.
 */
object SummonerProtocol extends DefaultJsonProtocol {
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
