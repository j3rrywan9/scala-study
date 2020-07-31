import sbt._

object Dependencies {
  lazy val json4sVersion = "3.6.7"
  lazy val logbackVersion = "1.2.3"
  lazy val scalaCheckVersion = "1.14.3"
  lazy val scalaLoggingVersion = "3.9.2"
  lazy val scalaTestVersion = "3.1.2"
  lazy val scalaTestPlusVersion = "3.1.0.0-RC2"
  lazy val springBootVersion = "1.5.7.RELEASE"
  lazy val typesafeConfigVersion = "1.3.3"

  val json4s = "org.json4s" %% "json4s-jackson" % json4sVersion
  val logback = "ch.qos.logback" % "logback-classic" % logbackVersion
  val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckVersion % Test
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test
  val scalaTestPlus = "org.scalatestplus" %% "scalatestplus-scalacheck" % scalaTestPlusVersion % Test
  val springBoot = "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion
  val typesafeConfig = "com.typesafe" % "config" % typesafeConfigVersion

  val backendDeps = Seq(
    json4s,
    logback,
    scalaCheck,
    scalaLogging,
    scalaTest,
    scalaTestPlus,
    springBoot,
    typesafeConfig
  )
}
