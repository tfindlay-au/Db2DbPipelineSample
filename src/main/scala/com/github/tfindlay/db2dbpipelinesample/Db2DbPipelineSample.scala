package com.github.tfindlay.db2dbpipelinesample

import java.util.Properties

import org.apache.spark.sql.{SaveMode, SparkSession}

object Db2DbPipelineSample {

  def main(args: Array[String]): Unit = {
    // Start Apache Spark
    val spark = SparkSession.builder.getOrCreate()

    // Read, Transform, Write the data
    spark.read
      .jdbc(DbConnectionHelper.buildDatabaseURL(), "tableName", DbConnectionHelper.buildDatabaseProperties())
      .transform(Transformations.withHasPositiveMood())
      .transform(Transformations.withIsTeenager())
      .transform(Transformations.withWhatToDo())
      .write
      .mode(SaveMode.Append)
      .jdbc(DbConnectionHelper.buildDatabaseURL(), "newTableName", DbConnectionHelper.buildDatabaseProperties())
  }
}
