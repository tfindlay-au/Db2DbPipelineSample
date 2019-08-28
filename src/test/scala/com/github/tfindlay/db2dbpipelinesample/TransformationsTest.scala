package com.github.tfindlay.db2dbpipelinesample

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.{Matchers, WordSpec}

class TransformationsTest extends WordSpec with Matchers with DataFrameSuiteBase {

  "withIsTeenager" must {
    "indicate true if age is between 13 to 19" in {

    }
    "indicate false if age is less than 13" in {

    }
    "indicate false if age is greater than 19" in {

    }
  }

}
