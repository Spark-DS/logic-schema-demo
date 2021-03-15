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

package sparkDS.logicSchema.demo.dataSpec.columnTypes

import sparkDS.logicSchema.dataSpec.ColumnType
import sparkDS.logicSchema.dataValidation.ValidationResultColumns.logic_validation_result.addColumnValidator
import sparkDS.logicSchema.demo.dataSpec.{ColumnValidators, ConsumerPrimitiveDataTypes}

class PriceAmountColumnType(name: String) extends ColumnType(name, ConsumerPrimitiveDataTypes.PriceAmount) {

  addColumnValidator(ColumnValidators.price_amount_validator)

}