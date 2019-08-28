package com.github.tfindlay.db2dbpipelinesample

import org.apache.spark.sql.{SaveMode, SparkSession}

object Db2DbPipelineSample {

  def main(args: Array[String]): Unit = {
    print("Starting transformation....")

    Class.forName("org.postgresql.Driver")

    // Start Apache Spark
    val spark = SparkSession.builder.master("local[*]").getOrCreate()

    // Read, Transform, Write the data
    spark.read
      .jdbc(DbConnectionHelper.buildDatabaseURL(), "mood_table", DbConnectionHelper.buildDatabaseProperties())
      .transform(Transformations.withHasPositiveMood())
      .transform(Transformations.withIsTeenager())
      .transform(Transformations.withWhatToDo())
      .write
      .mode(SaveMode.Overwrite)
      .jdbc(DbConnectionHelper.buildDatabaseURL(), "mood_table2", DbConnectionHelper.buildDatabaseProperties())
  }
}
