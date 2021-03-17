/*
 * Copyright 2021 by DJ Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sparkDS.logicSchema.demo.testData

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.scalatest._
import sparkDS.logicSchema.demo.dataSpec.dataFiles.OrderFile
import sparkDS.logicSchema.demo.testUtil.SparkTestUtil

import java.sql.Timestamp

class GenerateConsumerParquetFilesTest extends FlatSpec with Matchers {

  "========================================================================================================================" +
    "\nCase 1 - Generate valid sales parquet file" should "return true" in {
    val orderFileData: RDD[Row] = SparkTestUtil.spark.sparkContext.parallelize(
      Seq(
        Row(11L, 12L, Timestamp.valueOf("2014-01-01 23:00:01"), BigDecimal(199.0)),
        Row(21L, 22L, Timestamp.valueOf("2014-02-01 23:00:01"), BigDecimal(299.0)),
        Row(31L, 32L, Timestamp.valueOf("2014-03-01 23:00:01"), BigDecimal(399.0))
      )
    )

    val orderDF = SparkTestUtil.spark.createDataFrame(orderFileData, OrderFile.schema)
    println("\n\n GenerateConsumerParquetFilesTest:")
    println("\n\n     Test data files were not written to avoid interference with other test cases, uncomment to regenerate.\n\n\n")
    orderDF.coalesce(1)
    orderDF.show(999, truncate = false)
//    orderDF.write.mode(SaveMode.Overwrite).parquet(TestDataFile.validOrderFilePath)
  }

  "\nCase 2 - Generate invalid sales parquet file" should "return true" in {
    val orderFileData: RDD[Row] = SparkTestUtil.spark.sparkContext.parallelize(
      Seq(
        Row(11L, 12L, Timestamp.valueOf("2014-01-01 23:00:01"), BigDecimal(199.0)),
        Row(21L, 22L, Timestamp.valueOf("2014-02-01 23:00:01"), BigDecimal(299.0)),
        Row(31L, 32L, Timestamp.valueOf("2014-03-01 23:00:01"), BigDecimal(399.0)),

        // sale_product_price > 400
        Row(41L, 42L, Timestamp.valueOf("2014-04-01 23:00:01"), BigDecimal(499.0)),

        // sale_product_price > 400 and customer_id + product_id > 100
        Row(51L, 52L, Timestamp.valueOf("2014-05-01 23:00:01"), BigDecimal(599.0))
      )
    )

    val orderDF = SparkTestUtil.spark.createDataFrame(orderFileData, OrderFile.schema)
    println("\n\n GenerateConsumerParquetFilesTest:")
    println("\n\n     Test data files were not written to avoid interference with other test cases, uncomment to regenerate.\n\n\n")
    orderDF.coalesce(1)
    orderDF.show(999, truncate = false)
//    orderDF.write.mode(SaveMode.Overwrite).parquet(TestDataFile.invalidOrderFilePath)
  }

}
