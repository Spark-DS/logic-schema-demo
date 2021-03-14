package sparkDS.logicSchema.demo.dataSpec

import org.scalatest._
import sparkDS.logicSchema.demo.dataSpec.dataFiles.OrderFile
import sparkDS.logicSchema.demo.testData.TestDataFile

class ConsumerParquetFileTest extends FlatSpec with Matchers with BeforeAndAfterAll {

  "========================================================================================================================" +
    "\nCase 1 - Validation of valid order file" should "return true" in {
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

  "\nCase 2 - Validation of invalid order file" should "return false" in {
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