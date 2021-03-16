package sparkDS.logicSchema.demo.dataSpec

import org.scalatest._
import sparkDS.logicSchema.dataTypeComparison.{ComparisonResult, SchemaComparison}
import sparkDS.logicSchema.demo.dataSpec.dataFiles.OrderFile
import sparkDS.logicSchema.demo.testData.TestDataFile

class ConsumerParquetFileTest extends FlatSpec with Matchers with BeforeAndAfterAll {

  "========================================================================================================================" +
    "\nCase 1 - Schema validation of valid order file" should "return true" in {
    // Refer GenerateConsumerParquetFilesTest
    val orderDF = TestDataFile.validOrderDF
    val comparisonResult: ComparisonResult = SchemaComparison.compareSchema(
      "oderDF_schema", orderDF.schema,
      "OrderFile.schema", OrderFile.schema)
    assert(comparisonResult.isSame, "Schema validation of valid order file failed")
  }

  "\nCase 2 - Data validation of valid order file" should "return true" in {
    val orderDF = TestDataFile.validOrderDF
    val validatedOrderDF = OrderFile.validate(orderDF)
    validatedOrderDF.printSchema()
    validatedOrderDF.show(999, false)
    val invalidDF = validatedOrderDF.filter("size(logic_validation_result) > 0")
    println("\n\ninvalidDF:")
    invalidDF.show(999, false)
    println("\n\n")
    val isValidDF = invalidDF.isEmpty // Force to materialize
    assert(isValidDF, "Validation of valid order file failed")
  }

  "\nCase 3 - Data validation of invalid order file" should "return false" in {
    val orderDF = TestDataFile.invalidOrderDF
    val validatedOrderDF = OrderFile.validate(orderDF)
    validatedOrderDF.printSchema()
    validatedOrderDF.show(999, false)
    val invalidDF = validatedOrderDF.filter("size(logic_validation_result) > 0")
    println("\n\ninvalidDF:")
    invalidDF.show(999, false)
    println("\n\n")
    val isValidDF = invalidDF.isEmpty // Force to materialize
    assert(!isValidDF, "Validation of invalid order file failed")
  }

}