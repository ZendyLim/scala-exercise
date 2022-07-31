package tasks

case class WriteOrdinalNumberTask(
  number: Int
) extends BaseTask {
  // https://www.britannica.com/dictionary/eb/qa/How-To-Write-Ordinal-Numbers

  private def _getNLastDigits(number: Int, n: Int): Int = {
    number % scala.math.pow(10, n).intValue
  }

  private def suffix: String = {
    val lastTwoDigits = _getNLastDigits(number, 2) 

    lastTwoDigits match {
      case x if 11 until 19 contains x => "th"
      case x =>
        val lastDigit = _getNLastDigits(lastTwoDigits, 1) 

        lastDigit match {
          case 1 => "st"
          case 2 => "nd"
          case 3 => "rd"
          case _ => "th"
        }
    }
  }

  override def result: String = {
    s"$number".concat(suffix)
  }

  override def print: Unit = {
    println(s"$number => $result")
  }
}