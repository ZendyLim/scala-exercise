import scala.util.{Try, Success, Failure}

import org.joda.time.format._
import org.joda.time._

import tasks._

object Task3Main {
  def main(args: Array[String]) = {
    if (args.length < 1)
      throw new IllegalArgumentException(s"Not enough arguments.")

    val task = PersonalDataTask.initialize(args(0))

    task.print
  }
}