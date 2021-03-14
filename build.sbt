import sbt.url

organization := "com.github.spark-ds"
name := "logic-schema-demo"
version := "0.0.1"

homepage := Option(url("https://github.com/spark-ds/logic-schema"))
licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0"))
description := """spark-ds/logic-schema is a Scala library for data specification and validation across dataframes(hence logic schema), to help developing applications based on Apache Spark."""
scmInfo := Option(ScmInfo(
  url("https://github.com/spark-ds/logic-schema"),
  "scm:git@github.com:spark-ds/logic-schema.git"))
developers := List(
  Developer(
    id    = "dj707chen",
    name  = "DJ Chen",
    email = "@dj707chen",
    url   = url("https://github.com/dj707chen")
  )
)

publishTo := sonatypePublishToBundle.value
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
sonatypeCredentialHost := "s01.oss.sonatype.org"

scalaVersion := "2.12.12"

val logicSchema = "com.github.spark-ds" %% "logic-schema" % "0.0.1"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % Test

libraryDependencies ++= Seq(logicSchema, scalaTest)
