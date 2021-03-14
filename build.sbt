import sbt.url

ThisBuild / scalaVersion := "2.12.12"
ThisBuild / version := "0.0.1"
ThisBuild / organization := "com.github.spark-ds"
ThisBuild / homepage := Option(url("https://github.com/spark-ds/logic-schema-demo"))
ThisBuild / licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / description := """spark-ds/logic-schema-demo is A demo consumer of logic-schema, a Scala library for data specification and validation across dataframes(hence logic schema), to help developing applications based on Apache Spark."""
ThisBuild / scmInfo := Option(ScmInfo(
  url("https://github.com/spark-ds/logic-schema-demo"),
  "scm:git@github.com:spark-ds/logic-schema-demo.git"))
ThisBuild / developers := List(
  Developer(
    id    = "dj707chen",
    name  = "DJ Chen",
    email = "@dj707chen",
    url   = url("https://github.com/dj707chen")
  )
)

ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
val sonatypeSettings: Seq[Def.Setting[_]] = Seq(
  publishArtifact in Test := false,
  resolvers ++= Seq("sonatype-public" at "https://s01.oss.sonatype.org/content/repositories/public"),
  publishTo := sonatypePublishToBundle.value
)

lazy val commonSettings = Seq(
  scalacOptions := Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-language:postfixOps"),
  Test / parallelExecution := false,
  // resolvers += Resolver.typesafeIvyRepo("releases"),
  // Adds a `src/test/scala-2.13+` source directory for Scala 2.13 and newer
  // and a `src/test/scala-2.13-` source directory for Scala version older than 2.13
  Test / unmanagedSourceDirectories += {
    val sourceDir = (Test / sourceDirectory).value
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, n)) if n >= 13 => sourceDir / "scala-2.13+"
      case _ => sourceDir / "scala-2.13-"
    }
  }
) ++ sonatypeSettings

val logicSchema = "com.github.spark-ds" %% "logic-schema" % "0.0.1"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % Test

lazy val logicSchemaDemo = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "logic-schema-demo",
    libraryDependencies ++= Seq(logicSchema, scalaTest)
  )
