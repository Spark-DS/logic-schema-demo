package sparkDS.logicSchema.demo.dataSpec

import org.apache.spark.sql.types.DataTypes
import org.scalatest._
import sparkDS.logicSchema.dataSpec.{AnalysisException, ColumnDataType}

class ColumnDataTypeTest extends FlatSpec with Matchers with BeforeAndAfterAll {

  "========================================================================================================================" +
    "\nCase 1 - Valid column data" should "throw" in {
    val priceAmountType: ColumnDataType = ColumnDataType("decimal(7,2)", DataTypes.createDecimalType(7, 2))
    println(s"priceAmountType=$priceAmountType")
    assert(priceAmountType != null)
  }

  "\nCase 2 - Invalid column data" should "throw" in {
    assertThrows[AnalysisException] {
      ColumnDataType("XXXdecimal(7,2)", DataTypes.createDecimalType(7, 2))
      fail("Expected RuntimeException not thrown")
    }
  }

  "\nCase 3 - Invalid decimal parameter(precision < scale)" should "throw" in {
    assertThrows[AnalysisException] {
      ColumnDataType("decimal(7,8)", DataTypes.createDecimalType(8, 7))
      fail("Expected RuntimeException not thrown")
    }
  }

}
