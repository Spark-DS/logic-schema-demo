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

import org.apache.spark.sql.DataFrame
import sparkDS.logicSchema.demo.testUtil.SparkTestUtil

object TestDataFile {
  // @formatter:off
  val validOrderFilePath   = "./src/test/resources/logicSchema/demo/dataFiles/validOrder.parquet"
  val invalidOrderFilePath = "./src/test/resources/logicSchema/demo/dataFiles/invalidOrder.parquet"

  def validOrderDF:   DataFrame = SparkTestUtil.spark.read.parquet(validOrderFilePath)
  def invalidOrderDF: DataFrame = SparkTestUtil.spark.read.parquet(invalidOrderFilePath)
  // @formatter:on
}