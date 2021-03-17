package sparkDS.logicSchema.demo.dataSpec

import org.apache.spark.sql.types.DataTypes
import org.scalatest._
import sparkDS.logicSchema.dataTypeComparison.ComparisonResult
import sparkDS.logicSchema.demo.dataSpec.dataFiles.OrderFile
import sparkDS.logicSchema.demo.testData.TestDataFile

class SchemaValidationTest extends FlatSpec with Matchers with BeforeAndAfterAll {

  "========================================================================================================================" +
    "\nCase 1 - Schema validation of valid order file" should "return true" in {
    // Refer GenerateConsumerParquetFilesTest
    val comparisonResult: ComparisonResult = OrderFile.validateSchema("validOrderDF_Schema", TestDataFile.validOrderDF.schema)
    assert(comparisonResult.isSame, s"Schema validation of valid order file failed, ${comparisonResult.diffs}")
  }

  "\nCase 2 - Schema validation of changed valid order file" should "return false" in {
    // Refer GenerateConsumerParquetFilesTest
    val origSchema = TestDataFile.validOrderDF.schema
    val newSchema = origSchema.add("dummy", DataTypes.StringType)
    val comparisonResult: ComparisonResult = OrderFile.validateSchema("changed_Schema", newSchema)
    assert(!comparisonResult.isSame, s"Schema validation of valid order file failed:\n${comparisonResult.diffs}")
  }

}