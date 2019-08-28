package com.github.tfindlay.db2dbpipelinesample

import org.apache.spark.sql.{SaveMode, SparkSession}

import scala.util.Random

object SampleDataGen {
  private val moods = Seq("happy", "sad", "glad", "mad", "rad")

  def generate(spark: SparkSession): Unit = {
    // Generate sample data
    val random = new Random

    // Use implicit Seq -> DataFrame conversion for ease of use
    import spark.implicits._

    (for (i <- 1 to 1000000) yield (random.nextInt(99), getRandomElement(moods, random)))
      .toDF("age", "mood")
      .write
      .mode(SaveMode.Overwrite)
      .jdbc(DbConnectionHelper.buildDatabaseURL(), "mood_table", DbConnectionHelper.buildDatabaseProperties())
  }

  def getRandomElement(list: Seq[String], random: Random): String =
    list(random.nextInt(list.length))

}
