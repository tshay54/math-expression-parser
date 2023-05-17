import sbt._

lazy val scalacheckVersion = "1.15.4"

lazy val scala212 = "2.12.6"
lazy val scala213 = "2.13.10"
lazy val scalatest = "3.2.15"
lazy val parserCombinations = "1.1.2"

ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
Test / packageBin / publishArtifact := true

lazy val commonSettings = Seq(
  organization := "io.github.facaiy",
  homepage     := Some(url("https://facaiy.github.io")),
  description  := "A scala library for parsing mathemitical expressions with support for parentheses and variables.",
  developers   := List(
    Developer("facaiy", "Yan Facai", "facaiy", url("http://www.tpolecat.org"))
  ),
  licenses ++= Seq(
    ("MIT",     url("http://opensource.org/licenses/MIT"))
  ),
  scalaVersion        := scala213,
  crossScalaVersions  := Seq(scala212, scala213),
  version := "0.5.0-SNAPSHOT"
)


lazy val core =
    project
    .in(file("."))
    .settings(commonSettings)
    .settings(name := "math-expression-parser")
    .settings(libraryDependencies  ++= Seq("org.scala-lang.modules" %% "scala-parser-combinators" % parserCombinations,
      "org.scalatest" %% "scalatest"                % scalatest % "test"

    ))

