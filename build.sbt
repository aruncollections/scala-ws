name := "scala-ws"

version := "1.0"

scalaVersion := "2.12.2"

organization := "mybiz"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"

libraryDependencies +="com.google.inject" % "guice" % "3.0"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.21"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"