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
import sparkDS.logicSchema.demo.dataSpec.columns._

//@formatter:off
object CustomerFileColumns {
  val customer_id           = new CustomerId()
  val customer_name         = new CustomerName()
  val date_of_birth         = new DateOfBirth()
  val joined_date           = new JoinedDate()
  val street_address        = new StreetAddress()
  val city_name             = new CityName()
  val postal_code           = new PostalCode()
  val postal_state          = new PostalState()
}
//@formatter:on

object CustomerFile extends DataFile(
  "CustomerFile",
  List[ColumnType](
    CustomerFileColumns.customer_id,
    CustomerFileColumns.customer_name,
    CustomerFileColumns.date_of_birth,
    CustomerFileColumns.street_address,
    CustomerFileColumns.city_name,
    CustomerFileColumns.postal_code,
    CustomerFileColumns.postal_state,
    CustomerFileColumns.joined_date
  )
)