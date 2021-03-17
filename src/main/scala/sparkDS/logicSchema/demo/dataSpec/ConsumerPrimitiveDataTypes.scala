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

package sparkDS.logicSchema.demo.dataSpec

import org.apache.spark.sql.types.DataTypes
import sparkDS.logicSchema.dataSpec.ColumnDataType

object ConsumerPrimitiveDataTypes {
  val PriceAmount: ColumnDataType = new ColumnDataType("decimal(7,2)", DataTypes.createDecimalType(7, 2))
  val SalesAmount: ColumnDataType = new ColumnDataType("decimal(9,2)", DataTypes.createDecimalType(9, 2))
}
