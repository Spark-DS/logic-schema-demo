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

package sparkDS.logicSchema.demo.dataSpec.columns

import sparkDS.logicSchema.dataSpec.sysColumnTypes._
import sparkDS.logicSchema.demo.dataSpec.columnTypes.{PriceAmountColumnType, SalesAmountColumnType}

//@formatter:off
class CustomerId          extends LongColumnType("customer_id")
class CustomerName        extends StringColumnType("customer_name")
class DateOfBirth         extends DateColumnType("date_of_birth")
class JoinedDate          extends DateColumnType("joined_date")
class StreetAddress       extends StringColumnType("street_address")
class CityName            extends StringColumnType("city_name")
class PostalCode          extends StringColumnType("postal_code")
class PostalState         extends StringColumnType("postal_state")

class ProductId           extends LongColumnType("product_id")
class ProductName         extends StringColumnType("product_name")
class ListingProductPrice extends PriceAmountColumnType("listing_product_price")
class SaleProductPrice    extends PriceAmountColumnType("sale_product_price")
class SaleTimestamp       extends TimestampColumnType("sale_timestamp")
class SalesMonth          extends SalesAmountColumnType("sales_month")
class SalesYear           extends SalesAmountColumnType("sales_year")
//@formatter:on
