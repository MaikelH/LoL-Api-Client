package org.chronos.lol.api.models

/**
 * Created by Maikel on 12/12/13
 */
case class Champion(active:Boolean,
                    attackRank:Int,
                    botEnabled:Boolean,
                    botMmEnabled: Boolean,
                    defenseRank: Int,
                    difficultyRank: Int,
                    freeToPlay: Boolean,
                    id: Int,
                    magicRank: Int,
                    name: String,
                    rankedPlayEnabled: Boolean)
