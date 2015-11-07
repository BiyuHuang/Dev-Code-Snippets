name := "for-future-demo"

version := "1.0"

scalaVersion := "2.10.4"

javaOptions ++= Seq("-Xms256M", "-Xmx512M", "-XX:MaxPermSize=512M", "-XX:+CMSClassUnloadingEnabled")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"

libraryDependencies += "io.spray" % "spray-routing" % "1.2.3"


