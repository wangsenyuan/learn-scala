import sbt.Keys._

name := "ALG-S"

scalaVersion := "2.13.0"

scalaVersion in ThisBuild := "2.13.0"

autoScalaLibrary := false

/* ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
} */

//resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
//resolvers += Classpaths.typesafeResolver

libraryDependencies ++= List(
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalaz" %% "scalaz-core" % "7.3.0-M31",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.3.0-M31" % "test",
  "com.typesafe.play" %% "play-json" % "2.8.0-M6"
)


unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/main/pat").value
unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/main/s99").value
unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/test/s99").value
unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/main/fp").value
unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/main/jisuanke").value
unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/main/leetcode").value
unmanagedSourceDirectories in Compile += baseDirectory(_ / "src/test/leetcode").value

unmanagedClasspath in Test += baseDirectory.value / "src/test/scala"
unmanagedClasspath in Test += baseDirectory.value / "src/test/leetcode"


retrieveManaged := true

scalacOptions += "-feature"
scalacOptions += "-target:jvm-1.8"

//initialCommands in console := "import scalaz._, Scalaz._"
