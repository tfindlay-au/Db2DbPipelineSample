package com.github.tfindlay.db2dbpipelinesample

import java.util.Properties

object DbConnectionHelper {
  def buildDatabaseURL() : String = {
    // TODO Push configuration out to external file
    val jdbcHostname = "localhost"
    val jdbcPort = 5432
    val jdbcDatabase = "postgres"

    // Create the JDBC URL without passing in the user and password parameters.
    s"jdbc:postgresql://${jdbcHostname}:${jdbcPort}/${jdbcDatabase}"
  }

  def buildDatabaseProperties(): Properties = {
    val jdbcUsername = "postgres"
    val jdbcPassword = "mysecretpassword"

    // Create a Properties() object to hold the parameters.
    import java.util.Properties
    val connectionProperties = new Properties()
    connectionProperties.put("user", s"${jdbcUsername}")
    connectionProperties.put("password", s"${jdbcPassword}")
    connectionProperties
  }

}
