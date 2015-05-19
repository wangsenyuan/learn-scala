import sbt.Keys._

name := "ALG-S"

scalaVersion := "2.11.2"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies ++= List(
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "org.scalaz" %% "scalaz-effect" % "7.1.0",
  "org.scalaz" %% "scalaz-typelevel" % "7.1.0",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.1.0" % "test"
)

unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
  Seq(
    base / "src/main/pat",
    base / "src/main/s99",
    base / "src/test/s99",
    base / "src/main/fp",
    base / "src/main/jisuanke",
    base / "src/main/leetcode"
  )
}

unmanagedClasspath in Test += baseDirectory.value / "src/test/scala"

retrieveManaged := true

scalacOptions += "-feature"

initialCommands in console := "import scalaz._, Scalaz._"