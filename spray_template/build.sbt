organization  := "com.for.future"

version       := "1.0.0"

scalaVersion  := "2.10.4"

javaOptions ++= Seq("-Xms256M", "-Xmx512M", "-XX:MaxPermSize=512M", "-XX:+CMSClassUnloadingEnabled")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"

libraryDependencies += "io.spray" % "spray-can_2.10"% "1.3.2"

libraryDependencies += "io.spray" % "spray-servlet_2.10"% "1.3.2"

libraryDependencies += "io.spray" % "spray-routing_2.10"% "1.3.2"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10"% "2.3.5"

libraryDependencies += "org.json4s" % "json4s-native_2.10"% "3.2.4"
