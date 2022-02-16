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
  ("ImageJ" at "https://maven.scijava.org/content/repositories/public/"),
  //("Boundless" at "http://repo.boundlessgeo.com/main").withAllowInsecureProtocol(true),
  ("osgeo" at "https://repo.osgeo.org/repository/geotools-releases"),
  ("geosolutions" at "https://maven.geo-solutions.it/"),
  //("Hibernate" at "http://www.hibernatespatial.org/repository").withAllowInsecureProtocol(true)
)

//val simplu3DVersion = "1.2-SNAPSHOT"
val simplu3D_experimentsVersion = "1.2-SNAPSHOT"
//val geotoolsVersion = "18.4"
//val geotoolsVersion = "21.0"

//useCoursier := false
updateOptions := updateOptions.value.withLatestSnapshots(true)


libraryDependencies ++= Seq(
  //"fr.ign.cogit" % "simplu3d" % simplu3DVersion,
  "fr.ign.cogit" % "simplu3d-experiments" % simplu3D_experimentsVersion
  // depends on 1.2 snapshot, gexygene 1.10 https://github.com/SimPLU3D/simplu3D-experiments/blob/master/pom.xml https://github.com/IGNF/geoxygene/blob/master/pom.xml
)

/*
libraryDependencies ++= Seq(
  "org.geotools" % "gt-grid" % geotoolsVersion,
  "org.geotools" % "gt-coverage" % geotoolsVersion,
  "org.geotools" % "gt-geotiff" % geotoolsVersion,
  "org.geotools" % "gt-image" % geotoolsVersion,
  "org.geotools" % "gt-referencing" % geotoolsVersion,
  "org.geotools" % "gt-epsg-hsql" % geotoolsVersion,
  //"org.geotools" % "gt-epsg-extension" % geotoolsVersion,
  "org.geotools" % "gt-shapefile" % geotoolsVersion,
  "org.geotools" % "gt-graph" % geotoolsVersion,
  "org.geotools" % "gt-metadata" % geotoolsVersion,
  "org.geotools" % "gt-opengis" % geotoolsVersion,
  "org.geotools" % "gt-main" % geotoolsVersion,
  //"org.geotools" % "gt-api" % geotoolsVersion,
  "fr.ign.cogit" % "simplu3d" % simplu3DVersion excludeAll(ExclusionRule(organization = "org.geotools")) // issue with some methods called by geoxygene -> should not exclude here and use latest geotools version?
)*/

/*
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
*/