val ScalaVersion = "2.13.8"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-exercise",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := ScalaVersion,

    libraryDependencies ++= Seq(
      "joda-time" % "joda-time" % "2.10.14",
      "org.joda" % "joda-convert" % "2.2.1",
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )