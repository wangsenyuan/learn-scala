import sbt.Keys._

name := "ALG-S"

scalaVersion := "2.12.1"

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

//resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies ++= List(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalaz" %% "scalaz-core" % "7.2.8",
  //"org.scalaz" %% "scalaz-effect" % "7.2.0",
  //"org.scalaz" %% "scalaz-typelevel" % "7.2.0",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.8" % "test"
)

unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
  Seq(
    base / "src/main/pat",
    base / "src/main/s99",
    base / "src/test/s99",
    base / "src/main/fp",
    base / "src/main/jisuanke",
    base / "src/main/leetcode",
    base / "src/test/leetcode"
  )
}

unmanagedClasspath in Test += baseDirectory.value / "src/test/scala"

unmanagedClasspath in Test += baseDirectory.value / "src/test/leetcode"


retrieveManaged := true

scalacOptions += "-feature"

initialCommands in console := "import scalaz._, Scalaz._"