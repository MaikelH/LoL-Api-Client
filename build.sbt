name := "LoL-Api-Client"

version := "0.5-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++=  Seq(
                            "io.spray" %%  "spray-json" % "1.2.5",
                            "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
                            "org.slf4j" % "slf4j-nop" % "1.6.4",
                            "net.virtual-void" %%  "json-lenses" % "0.5.4")

organization := "org.chronos"

homepage := Some(url("https://github.com/MaikelH/LoL-Api-Client"))

licenses in GlobalScope += "LGPL 3" -> url("https://www.gnu.org/licenses/lgpl.html")

    