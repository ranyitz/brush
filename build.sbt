ThisBuild / scalaVersion := "2.12.1"
ThisBuild / version := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "brush",
  )

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.2.1")
