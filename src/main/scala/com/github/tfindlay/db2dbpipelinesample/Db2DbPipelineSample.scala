package com.github.tfindlay.db2dbpipelinesample

import java.util.Properties

import org.apache.spark.sql.{SaveMode, SparkSession}

object Db2DbPipelineSample {

  def main(args: Array[String]): Unit = {
    // Program starts here

    // Start Apache Spark
    val spark = SparkSession.builder.getOrCreate()

    // Read the data
    spark.read
      .jdbc(buildDatabaseURL, "tableName", buildDatabaseProperties)
      //      .transform( .... )
      //      .transform( .... )
      //      .transform( .... )
      .write
      .mode(SaveMode.Append)
      .jdbc(buildDatabaseURL, "newTableName", buildDatabaseProperties)
  }

  def buildDatabaseURL() : String = {
    // TODO Push configuration out to external file
    val jdbcHostname = "<hostname>"
    val jdbcPort = 1433
    val jdbcDatabase = "<database>"

    // Create the JDBC URL without passing in the user and password parameters.
    s"jdbc:postgresql://${jdbcHostname}:${jdbcPort}/${jdbcDatabase}"
  }

  def buildDatabaseProperties(): Properties = {
    val jdbcUsername = "<username>"
    val jdbcPassword = "<password>"

    // Create a Properties() object to hold the parameters.
    import java.util.Properties
    val connectionProperties = new Properties()
    connectionProperties.put("user", s"${jdbcUsername}")
    connectionProperties.put("password", s"${jdbcPassword}")
    connectionProperties
  }

}
