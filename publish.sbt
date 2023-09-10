ThisBuild / organization := "io.github.ranyitz"
ThisBuild / organizationName := "ranyitz"
ThisBuild / organizationHomepage := Some(url("https://ranyitz.github.io"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/ranyitz/brush"),
    "scm:git@github.com:ranyitz/brush.git",
  ),
)

ThisBuild / developers := List(
  Developer(
    id = "ranyitz",
    name = "Ran Yitzhaki",
    email = "ranyitz@gmail.com",
    url = url("https://ranyitz.github.io"),
  ),
)

ThisBuild / description := "Scala Terminal String Styling"
ThisBuild / licenses := List("MIT" -> new URL("https://opensource.org/license/mit/"))
ThisBuild / homepage := Some(url("https://github.com/ranyitz/brush"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

ThisBuild / publishMavenStyle := true

ThisBuild / versionScheme := Some("early-semver")
