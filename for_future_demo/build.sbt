import Keys._
import sbtassembly.Plugin.{PathList, AssemblyKeys, MergeStrategy}
import spray.revolver.RevolverPlugin.Revolver
import de.johoop.jacoco4sbt._
import JacocoPlugin._
import AssemblyKeys._

name := "for-future-demo"

version := "1.0"

scalaVersion := "2.10.4"

javaOptions ++= Seq("-Xms256M", "-Xmx512M", "-XX:MaxPermSize=512M", "-XX:+CMSClassUnloadingEnabled")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"

libraryDependencies += "io.spray" % "spray-routing" % "1.2.3"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.9"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.7"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

// libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.2"

libraryDependencies += "org.scalanlp" %% "breeze" % "0.10"

libraryDependencies += "org.scalanlp" %% "breeze-natives" % "0.10"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "1.6.1"

parallelExecution in ThisBuild := false

parallelExecution in test := false

parallelExecution := false

aggregate in clean := false

traceLevel := 10

exportJars := true

javacOptions ++= Seq("-encoding", "UTF-8")

Revolver.settings

//------------------------------------------------------------
// settings for CI
//------------------------------------------------------------
jacoco.settings

parallelExecution in jacoco.Config := false

// create beautiful scala test report
testOptions in Test += Tests.Argument("-h", "target/html-test-report")

testOptions in Test += Tests.Argument("-o")

testOptions in jacoco.Config += Tests.Argument("-h", "target/html-test-report")

testOptions in jacoco.Config += Tests.Argument("-o")

testOptions in accTest += Tests.Argument("-h", "target/accept-test-report")

testOptions in accTest += Tests.Argument("-o")

testOptions in unitTest += Tests.Argument("-h", "target/unit-test-report")

//testOptions in unitTest += Tests.Argument("-o")


//------------------------------------------------------------
// settings for assembly
//------------------------------------------------------------

assemblySettings

jarName in assembly := "for-future-demo.jar"

test in assembly := {}

mainClass in assembly := Some("EXAMPLE")

//To exclude Scala library when run sbt assembly
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = true)

mergeStrategy in assembly := {
  case PathList("core-site.xml") => MergeStrategy.rename
  case PathList("hbase-site.xml") => MergeStrategy.rename
  case PathList("hdfs-site.xml") => MergeStrategy.rename
  case PathList("hive-site.xml") => MergeStrategy.rename
  case PathList(ps@_*) if ps.last endsWith ".thrift" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".default" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".RSA" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".properties" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".class" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xsd" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".dtd" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".txt" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".jar" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".providers" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith "mailcap" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith "jersey-module-version" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".so" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".tmpl" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".css" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".js" => MergeStrategy.first
  case x =>
    val oldStrategy = (mergeStrategy in assembly).value
    oldStrategy(x)
}
