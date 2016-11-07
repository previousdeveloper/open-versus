
name := "Open-Versus"
organization := "previousDev"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"


fork in run := true


javaOptions ++= Seq(
  "-Dlog.service.output=/dev/stderr",
  "-Dlog.access.output=/dev/stderr")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com")



lazy val versions = new {
  val finatra = "2.1.4"
  val guice = "4.0"
  val logback = "1.0.13"
  val mockito = "1.9.5"
  val scalatest = "2.2.3"
  val specs2 = "2.3.12"
  val config = "1.3.1"
  val akka = "2.4.11"
  val scalaLikeJdbc = "2.4.2"

}

libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % versions.finatra,
  "com.twitter.finatra" %% "finatra-slf4j" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "com.typesafe" % "config" % versions.config,

  "com.typesafe.akka" %% "akka-actor" % versions.akka,
  "com.typesafe.akka" %% "akka-slf4j" % versions.akka,

  "org.scalikejdbc" %% "scalikejdbc"       % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-config" % versions.scalaLikeJdbc,
  "mysql" % "mysql-connector-java" % "6.0.5",
  "ch.qos.logback" % "logback-classic" % versions.logback % "test",

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test" classifier "tests",

  "com.typesafe.akka" %% "akka-testkit" % versions.akka,


  "org.mockito" % "mockito-core" % versions.mockito % "test",
  "org.scalatest" %% "scalatest" % versions.scalatest % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test",

  "org.specs2" %% "specs2" % versions.specs2 % "test")

