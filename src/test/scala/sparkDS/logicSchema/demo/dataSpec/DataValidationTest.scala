package sparkDS.logicSchema.demo.dataSpec

import org.scalatest._
import sparkDS.logicSchema.demo.dataSpec.dataFiles.OrderFile
import sparkDS.logicSchema.demo.testData.TestDataFile

class DataValidationTest extends FlatSpec with Matchers with BeforeAndAfterAll {

  "========================================================================================================================" +
    "\nCase 1 - Data validation of valid order file" should "return true" in {
    val orderDF = TestDataFile.validOrderDF
    val validatedOrderDF = OrderFile.validateData(orderDF)
    validatedOrderDF.printSchema()
    validatedOrderDF.show(999, truncate = false)
    val invalidDF = validatedOrderDF.filter("size(logic_validation_result) > 0")
    println("\n\ninvalidDF:")
    invalidDF.show(999, truncate = false)
    println("\n\n")
    val isValidDF = invalidDF.isEmpty // Force to materialize
    assert(isValidDF, "Validation of valid order file failed")
  }

  "\nCase 2 - Data validation of invalid order file" should "return false" in {
    val orderDF = TestDataFile.invalidOrderDF
    val validatedOrderDF = OrderFile.validateData(orderDF)
    validatedOrderDF.printSchema()
    validatedOrderDF.show(999, truncate = false)
    val invalidDF = validatedOrderDF.filter("size(logic_validation_result) > 0")
    println("\n\ninvalidDF:")
    invalidDF.show(999, truncate = false)
    println("\n\n")
    val isValidDF = invalidDF.isEmpty // Force to materialize
    assert(!isValidDF, "Validation of invalid order file failed")
    assert(invalidDF.count() == 2, "Count of invalid records did not match")
  }

}