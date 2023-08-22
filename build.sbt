import Dependencies._

name := "Scala Study"

ThisBuild / organization := "me.jerrywang.scala"

ThisBuild / version := "1.0.0-SNAPSHOT"

lazy val scalaMajorVersion = "2.13"
lazy val scalaMinorVersion = "11"

ThisBuild / scalaVersion := s"$scalaMajorVersion.$scalaMinorVersion"

ThisBuild / scalacOptions += "-deprecation"

lazy val algorithms = (project in file("algorithms"))
  .settings(
    libraryDependencies ++= backendDeps
  )

lazy val examples = (project in file("examples"))
  .settings(
    libraryDependencies ++= backendDeps
  )
