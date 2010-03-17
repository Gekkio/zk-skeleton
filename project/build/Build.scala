import fi.jawsy.sbtplugins.jrebel.JRebelProject
import sbt._

class ZKSkeleton(info: ProjectInfo) extends DefaultWebProject(info) with JRebelProject {

  object Versions {
    val geronimoServlet = "1.2"
    val jetty = "7.0.1.v20091125"
    val zk = "5.0.1"
  }

  val geronimoServletSpec = "org.apache.geronimo.specs" % "geronimo-servlet_2.5_spec" % Versions.geronimoServlet % "provided"
  val zk = "org.zkoss.zk" % "zk" % Versions.zk withSources
  val zkPlus = "org.zkoss.zk" % "zkplus" % Versions.zk withSources
  val zkZhtml = "org.zkoss.zk" % "zhtml" % Versions.zk withSources
  val zkZul = "org.zkoss.zk" % "zul" % Versions.zk withSources

  val jettyServer = "org.eclipse.jetty" % "jetty-server" % Versions.jetty % "test"
  val jettyWebapp = "org.eclipse.jetty" % "jetty-webapp" % Versions.jetty % "test"
  val localMaven = "Local Maven Repository" at "file://" + Path.userHome + "/.m2/repository"

  override def jettyContextPath = "/zkskeleton"
  override def jettyRunClasspath = super.jettyRunClasspath +++ ("lib_local") +++ ("lib_local" ** "*.jar")
  override def compileClasspath = super.compileClasspath --- (managedDependencyRootPath ** ("*-sources.jar" | "*-javadoc.jar"))
  override def publicClasspath = super.publicClasspath --- (managedDependencyRootPath ** ("*-sources.jar" | "*-javadoc.jar"))

  override def ivyXML =
    <dependencies>
      <exclude org="javax.servlet" module="servlet-api" />
    </dependencies>

}
