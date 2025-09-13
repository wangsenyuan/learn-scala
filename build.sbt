import sbt.Keys._

name := "ALG-S"

scalaVersion := "3.7.3"

autoScalaLibrary := false

libraryDependencies ++= List(
  "org.scalactic" %% "scalactic" % "3.2.18",
  "org.scalatest" %% "scalatest" % "3.2.18" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  ("org.scalaz" %% "scalaz-core" % "7.3.8").cross(CrossVersion.for3Use2_13),
  ("org.scalaz" %% "scalaz-scalacheck-binding" % "7.3.8" % "test").cross(CrossVersion.for3Use2_13),
  "org.playframework" %% "play-json" % "3.0.4"
)
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/main/pat"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/main/s99"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/test/s99"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/main/fp"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/main/jisuanke"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/main/leetcode"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/test/leetcode"

Test / unmanagedClasspath += baseDirectory.value / "src/test/scala"
Test / unmanagedClasspath += baseDirectory.value / "src/test/leetcode"


retrieveManaged := true

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-source:3.4-migration",
  "-rewrite",
  "-language:deprecated.symbolLiterals"
)

javacOptions ++= Seq("--release", "21")
