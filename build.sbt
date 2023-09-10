ThisBuild / scalaVersion := "2.13.11"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "io.github.ranyitz"
ThisBuild / organizationName := "ranyitz"

lazy val root = (project in file("."))
  .settings(
    name := "brush",
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
