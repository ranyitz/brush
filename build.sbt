val Scala212: String = "2.12.18"
val Scala213: String = "2.13.11"
val Scala3: String = "3.3.0"

ThisBuild / scalaVersion := Scala213
ThisBuild / version := "0.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "brush",
    libraryDependencies += "io.monix" %% "minitest" % "2.9.6" % "test",
    testFrameworks += new TestFramework("minitest.runner.Framework")
  )
