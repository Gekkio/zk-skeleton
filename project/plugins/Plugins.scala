import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val jrebel = "fi.jawsy" % "sbt-jrebel-plugin" % "0.1-SNAPSHOT"
}
