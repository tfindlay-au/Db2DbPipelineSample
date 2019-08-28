package com.github.tfindlay.db2dbpipelinesample

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.{Row, SparkSession}
import org.scalatest.{Matchers, WordSpec}

class TransformationsTest extends WordSpec with Matchers with DataFrameSuiteBase {

  "withIsTeenager" must {
    "indicate true if age is between 13 to 19" in {
      val spark = SparkSession.builder.getOrCreate()

      import spark.implicits._

      // Given an input data frame ...
      val inputDf = Seq((50,"sad")).toDF("age","mood")

      // When we call the function ...
      val resultDataFrame = Transformations.withIsTeenager()(inputDf)

      // Then the result should be ...
      val expectedDf = Seq((50,"sad", false)).toDF("age","mood","is_teenager")
      assertDataFrameEquals(expectedDf, resultDataFrame)
    }
    "indicate false if age is less than 13" in {

    }
    "indicate false if age is greater than 19" in {

    }
  }

}
