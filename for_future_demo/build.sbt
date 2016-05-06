name := "for-future-demo"

version := "1.0"

scalaVersion := "2.10.4"

javaOptions ++= Seq("-Xms256M", "-Xmx512M", "-XX:MaxPermSize=512M", "-XX:+CMSClassUnloadingEnabled")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"

libraryDependencies += "io.spray" % "spray-routing" % "1.2.3"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.9"

//libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.7"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.2"

libraryDependencies += "org.scalanlp" %% "breeze" % "0.10"

libraryDependencies += "org.scalanlp" %% "breeze-natives" % "0.10"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "1.6.1"
