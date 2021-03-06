package org.chronos.lol.api.services.V1_1.models

import java.sql.Timestamp

/**
 * Created by Maikel on 12/12/13
 */

case class Summoner(id: Long,
                    name: String,
                    profileIconId: Int,
                    revisionDate: Timestamp,
                    revisionDateStr: String,
                    summonerLevel: Int)
