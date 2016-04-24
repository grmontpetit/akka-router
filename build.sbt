name := "akka-router"

version := "0.0.1"

organization := "sniggel"

scalaVersion  := "2.11.4"

scalacOptions := Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

fork := true

libraryDependencies ++= {
  val akkaV = "2.4.1"
  Seq(
    "com.typesafe.akka"    %%  "akka-actor"     % akkaV,
    "com.typesafe.akka"    %%  "akka-testkit"   % akkaV   % "test",
    "org.scalatest"        %%   "scalatest"     % "2.2.1" % "test",
    "org.scala-lang.modules" %% "scala-async"   % "0.9.2",
    "com.typesafe.akka" %% "akka-camel" % "2.3.15",
    "com.typesafe.akka" %% "akka-remote" % "2.4.4"
  )
}

