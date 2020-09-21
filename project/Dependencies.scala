import sbt._

object Dependencies {
  lazy val json4sVersion = "3.6.7"
  lazy val logbackVersion = "1.2.3"
  lazy val scalaCheckVersion = "1.14.3"
  lazy val scalaLoggingVersion = "3.9.2"
  lazy val scalaTestVersion = "3.1.2"
  lazy val scalaTestPlusVersion = "3.1.0.0-RC2"
  lazy val springBootVersion = "2.3.4.RELEASE"
  lazy val typesafeConfigVersion = "1.4.0"

  val json4s = "org.json4s" %% "json4s-jackson" % json4sVersion
  val logback = "ch.qos.logback" % "logback-classic" % logbackVersion
  val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckVersion % Test
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test
  val scalaTestPlus = "org.scalatestplus" %% "scalatestplus-scalacheck" % scalaTestPlusVersion % Test
  val springBootStarterJetty = "org.springframework.boot" % "spring-boot-starter-jetty" % springBootVersion
  val springBootStarterWeb = "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion exclude("org.springframework.boot", "spring-boot-starter-tomcat")
  val typesafeConfig = "com.typesafe" % "config" % typesafeConfigVersion

  val backendDeps = Seq(
    json4s,
    logback,
    scalaCheck,
    scalaLogging,
    scalaTest,
    scalaTestPlus,
    springBootStarterJetty,
    springBootStarterWeb,
    typesafeConfig
  )
}
