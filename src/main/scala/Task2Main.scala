import scala.util.{Try, Success, Failure}

import org.joda.time.format._
import org.joda.time._

import tasks._

object Task2Main {
  def main(args: Array[String]) = {
    if (args.length < 2)
      throw new IllegalArgumentException(s"Not enough arguments.")

    val format = DateTimeFormat.forPattern("dd-MM-yyyy")

    val startDate = Try(format.parseDateTime(args(0))) match {
      case Success(date) => date
      case Failure(e) => throw new IllegalArgumentException(s"Start date (${args(0)}) is not a valid date format. (dd-MM-yyyy)")
    }

    val endDate = Try(format.parseDateTime(args(1))) match {
      case Success(date) => date
      case Failure(e) => throw new IllegalArgumentException(s"End date ${args(1)} is not a valid date format. (dd-MM-yyyy)")
    }

    val task = FindNumberOfSundaysTask.initialize(startDate, endDate)

    task.print
  }
}