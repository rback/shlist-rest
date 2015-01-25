import com.typesafe.sbt.SbtStartScript

lazy val commonSettings = Seq(
  organization := "com.github.rback",
  version := System.getProperty("releaseVersion", "trunk-SNAPSHOT"),
  scalaVersion := "2.11.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(SbtStartScript.startScriptForClassesSettings: _*).
  settings(
    name := "shlist-rest",
    libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % "2.3.0",
        "org.scalatra" %% "scalatra-json" % "2.3.0",
        "org.json4s" %% "json4s-native" % "3.2.11",
        "org.eclipse.jetty" % "jetty-webapp" % "9.2.6.v20141205",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
        "ch.qos.logback" % "logback-classic" % "1.0.13",
        "com.typesafe" % "config" % "1.2.1",
        "com.newrelic.agent.java" % "newrelic-agent" % "3.13.0"
    )
  )
