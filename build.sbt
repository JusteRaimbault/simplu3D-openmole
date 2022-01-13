scalaVersion := "2.13.1"

name := "simplu3D-openmole-plugin"

version := "1.0-SNAPSHOT"

//javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
//scalacOptions += "-target:jvm-1.8"

enablePlugins(SbtOsgi)
OsgiKeys.exportPackage := Seq("simplu3dopenmoleplugin.*")
OsgiKeys.importPackage := Seq("*;resolution:=optional")
OsgiKeys.privatePackage := Seq("""
|!scala.*,!java.*,META-INF.*;-split-package:=merge-first,
|*;-split-package:=merge-first
|""".stripMargin)
OsgiKeys.requireCapability := """osgi.ee;filter:="(&(osgi.ee=JavaSE)(version=1.8))""""

resolvers ++= Seq(
  ("IDB" at "http://igetdb.sourceforge.net/maven2-repository/").withAllowInsecureProtocol(true),
  //"Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
  Resolver.mavenLocal,
  ("IGN snapshots" at "https://forge-cogit.ign.fr/nexus/content/repositories/snapshots/").withAllowInsecureProtocol(true),
  ("IGN releases" at "https://forge-cogit.ign.fr/nexus/content/repositories/releases/").withAllowInsecureProtocol(true),
  //"ISC-PIF Public" at "http://maven.iscpif.fr/public/",
  //"ISC-PIF Snapshots" at "http://maven.iscpif.fr/ign-snapshots/",
  //"ISC-PIF Release" at "http://maven.iscpif.fr/ign-releases/",
  ("ImageJ" at "http://maven.imagej.net/content/repositories/public").withAllowInsecureProtocol(true),
  ("Boundless" at "http://repo.boundlessgeo.com/main").withAllowInsecureProtocol(true),
  ("osgeo" at "http://download.osgeo.org/webdav/geotools/").withAllowInsecureProtocol(true),
  ("geosolutions" at "http://maven.geo-solutions.it/").withAllowInsecureProtocol(true),
  ("Hibernate" at "http://www.hibernatespatial.org/repository").withAllowInsecureProtocol(true)
)

val simplu3DVersion = "1.3-SNAPSHOT"
val simplu3D_experimentsVersion = "1.2-SNAPSHOT"
val geotoolsGridVersion = "18.4"

libraryDependencies ++= Seq(
  "org.geotools" % "gt-grid" % geotoolsGridVersion,
  "org.geotools" % "gt-coverage" % geotoolsGridVersion,
  "org.geotools" % "gt-geotiff" % geotoolsGridVersion,
  "org.geotools" % "gt-image" % geotoolsGridVersion,
  "org.geotools" % "gt-referencing" % geotoolsGridVersion,
  "org.geotools" % "gt-epsg-hsql" % geotoolsGridVersion,
  //"org.geotools" % "gt-epsg-extension" % geotoolsGridVersion,
  "org.geotools" % "gt-shapefile" % geotoolsGridVersion,
  "org.geotools" % "gt-graph" % geotoolsGridVersion,
  "org.geotools" % "gt-metadata" % geotoolsGridVersion,
  "org.geotools" % "gt-opengis" % geotoolsGridVersion,
  "org.geotools" % "gt-main" % geotoolsGridVersion,
  "org.geotools" % "gt-api" % geotoolsGridVersion,
  "fr.ign.cogit" % "simplu3d" % simplu3DVersion
)

libraryDependencies += "fr.ign.cogit" % "simplu3d-experiments" % simplu3D_experimentsVersion excludeAll(
    ExclusionRule(organization = "org.geotools"),
    ExclusionRule(organization = "uk.ac.ed.ph.snuggletex"),
    ExclusionRule(organization = "vigna.dsi.unimi.it"),
    ExclusionRule(organization = "net.billylieurance.azuresearch"),
    ExclusionRule(organization = "net.sf.jafama"),
    ExclusionRule(organization = "net.sourceforge.jmatio"),
    ExclusionRule(organization = "jgrapht"),
    ExclusionRule(organization = "org.bethecoder"),
    ExclusionRule(organization = "com.aetrion.flickr"),
    ExclusionRule(organization = "com.caffeineowl.graphics"),
    ExclusionRule(organization = "de.bwaldvogel"),
    ExclusionRule(organization = "mnstarfire"),
    ExclusionRule(organization = "com.thoughtworks.xstream"),
    ExclusionRule(organization = "jfree"),
    ExclusionRule(organization = "javax.media"),
    ExclusionRule(organization = "org.slf4j")
  )
