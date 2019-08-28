package com.github.tfindlay.db2dbpipelinesample

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions.when

/**
 * This object contains a number of business rules used to transform
 * the sample data.
 *
 * By placing the logic in here it makes the code testable and reusable
 *
 * These transformations are also chainable so many transformations can be performed on a dataframe
 * @example <pre>
 *            df.transform(withIsTeenager)
 *              .transform(withHasPositiveMood)
 *          </pre>
 */
object Transformations {

  /**
   * This method provides a new column `is_teenager` which is a boolean flag based on the value of `age`
   * @note If this is between 13 and 19 then the value will be true.
   * @param df Input data frame with the age column
   * @return data frame with the `is_teenager` column
   */
  def withIsTeenager()(df: DataFrame): DataFrame = {
    df.withColumn("is_teenager", col("age").between(13, 19))
  }

  /**
   * This method returns a new column `has_positive_mood` which is a boolean flag based on the value of `mood`
   * @note The only detected moods are currently "happy" and "glad"
   * @param df
   * @return
   */
  def withHasPositiveMood()(df: DataFrame): DataFrame = {
    df.withColumn(
      "has_positive_mood",
      col("mood").isin("happy", "glad")
    )
  }

  /**
   * This method returns a new column `what_to_do` which is a string description based on the value of `is_teenager` and `has_positive_mood`
   * @param df
   * @return
   */
  def withWhatToDo()(df: DataFrame) = {
    df.withColumn(
      "what_to_do",
      when(
        col("is_teenager") && col("has_positive_mood"),
        "have a chat"
      )
    )
  }
}
