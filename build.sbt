name := "Db2DbPipelineSample"

version := "0.1"

scalaVersion := "2.12.9"
val sparkVersion = "2.4.3"

//---------------------
// Spark Framework
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-streaming" % sparkVersion

//---------------------
// Testing Frameworks
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies += "org.scalamock" %% "scalamock-core" % "3.6.0" % "test"
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % "test"
libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19" % "test"
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.4.3_0.12.0" % Test

//--------------------
// JDBC Connectivity
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.6"

//--------------------
// Configure Assembly plugin
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}