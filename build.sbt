// import Dependencies._

ThisBuild / scalaVersion := "2.13.11"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.ranyitz"
ThisBuild / organizationName := "ranyitz"

lazy val root = (project in file("."))
  .settings(
    name := "brush",
    // libraryDependencies += munit % Test,
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
