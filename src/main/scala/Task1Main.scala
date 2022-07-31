import scala.util.{Try, Success, Failure}

import tasks._

object Task1Main {
  def main(args: Array[String]) = {
    if (args.length < 1)
      throw new IllegalArgumentException("Not enough arguments.")

    val number = Try(args(0).toInt) match {
      case Success(n) => n
      case Failure(e) => throw new IllegalArgumentException(s"{${args(0)}} is not a valid integer.")
    }

    val task = WriteOrdinalNumberTask(number)

    task.print
  }
}