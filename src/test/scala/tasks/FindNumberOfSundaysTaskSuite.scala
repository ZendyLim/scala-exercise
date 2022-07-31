package tasks

import org.joda.time.format._
import org.joda.time._

import munit.Clue.generate

class FindNumberOfSundaysTaskSuite extends munit.FunSuite {
  val format = DateTimeFormat.forPattern("dd-MM-yyyy")

  test("should throw IllegalArgumentException with start date later than end date") {
    interceptMessage[IllegalArgumentException]("Start date can't be later than end date.") {

      val startDate = format.parseDateTime("01-02-2022")
      val endDate = format.parseDateTime("01-01-2022")
      
      FindNumberOfSundaysTask.initialize(startDate, endDate)
    }
  }

  test("should return '1' on input ('31-07-2022', '1-08-2022')") {
    val startDate = format.parseDateTime("31-07-2022")
    val endDate = format.parseDateTime("1-08-2022")
    assertEquals(FindNumberOfSundaysTask(startDate, endDate).result, "1")
  }

  test("should return '0' on input ('1-08-2022', '1-08-2022')") {
    val startDate = format.parseDateTime("1-08-2022")
    val endDate = format.parseDateTime("1-08-2022")
    assertEquals(FindNumberOfSundaysTask(startDate, endDate).result, "0")
  }

  test("should return '2' on input ('24-07-2022', '1-08-2022')") {
    val startDate = format.parseDateTime("24-07-2022")
    val endDate = format.parseDateTime("1-08-2022")
    assertEquals(FindNumberOfSundaysTask(startDate, endDate).result, "2")
  }
}

