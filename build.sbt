organization := "reaktor"

name := "example-servlet"

version := System.getProperty("releaseVersion", "trunk-SNAPSHOT")

scalaVersion := "2.10.3"

parallelExecution in Test := false

parallelExecution in IntegrationTest := false

crossPaths := false

resolvers += "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.2.2",
  "org.scalatra" %% "scalatra-json" % "2.2.2",
  "org.json4s" %% "json4s-native" % "3.2.6",
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.1.v20140108" % "container,compile",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,compile" artifacts Artifact( "javax.servlet", "jar", "jar"),
  "ch.qos.logback" % "logback-classic" % "1.0.13"
)

seq(webSettings :_*)
