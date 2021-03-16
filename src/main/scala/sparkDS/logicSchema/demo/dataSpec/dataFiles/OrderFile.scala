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

package sparkDS.logicSchema.demo.dataSpec.dataFiles

import sparkDS.logicSchema.dataSpec.{ColumnType, DataFile}
import sparkDS.logicSchema.demo.dataSpec.RecordValidators
import sparkDS.logicSchema.demo.dataSpec.columns._

//@formatter:off
object OrderFileColumns {
  val customer_id           = new CustomerId(true)
  val product_id            = new ProductId(true)
  val sale_product_price    = new SaleProductPrice()
  val sale_timestamp        = new SaleTimestamp()
}
//@formatter:on

object OrderFile extends DataFile(
  "OrderFile",
  List[ColumnType](
    OrderFileColumns.customer_id,
    OrderFileColumns.product_id,
    OrderFileColumns.sale_timestamp,
    OrderFileColumns.sale_product_price
  )
) {

  addRecordValidator(RecordValidators.order_validator)

}