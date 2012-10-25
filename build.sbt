seq(jrebelSettings :_*)

seq(webSettings :_*)

organization := "zk-skeleton"

name := "zk-skeleton"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

libraryDependencies ++= {
  val javaxServlet = "3.0.1"
  val jetty = "8.0.4.v20111024"
  val zk = "6.5.0"
  Seq(
    "javax.servlet" % "javax.servlet-api" % javaxServlet,
    "org.eclipse.jetty" % "jetty-webapp" % jetty % "container",
    "org.zkoss.common" % "zcommon" % zk,
    "org.zkoss.common" % "zweb" % zk,
    "org.zkoss.zk" % "zk" % zk,
    "org.zkoss.zk" % "zkplus" % zk,
    "org.zkoss.zk" % "zhtml" % zk,
    "org.zkoss.zk" % "zul" % zk
  )
}

jrebel.webLinks <++= webappResources in Compile

scanInterval in Compile <<= (jrebel.enabled) { enabled =>
  if (enabled) 0 else 3
}

apps in container.Configuration <<= (deployment in Compile) map { d =>
	Seq("/zkskeleton" -> d)
}

resolvers ++= Seq(
	"m2-zk" at "http://mavensync.zkoss.org/maven2"
)

licenses += ("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))

ivyXML :=
  <dependencies>
    <exclude org="org.atmosphere" module="atmosphere-ping" />
  </dependencies>
