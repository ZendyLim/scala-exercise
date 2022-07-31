package tasks

import org.joda.time.format._
import org.joda.time._

case class FindNumberOfSundaysTask private(
  start: DateTime,
  end: DateTime,
) extends BaseTask {
  private val format = "dd-MM-yyyy"

  private def firstSundayAfterStartDate: DateTime = {
    val sunday = start.withDayOfWeek(DateTimeConstants.SUNDAY)

    if (start.isAfter(sunday)) {
      sunday.plusWeeks(1)
    } else {
      sunday
    }
  }

  private def lastSundayBeforeEndDate: DateTime = {
    val sunday = end.withDayOfWeek(DateTimeConstants.SUNDAY)

    if (sunday.isAfter(end)) {
      sunday.minusWeeks(1)
    } else {
      sunday
    }
  }

  private def numberOfSunday: Int = {
    if (firstSundayAfterStartDate.isAfter(end) || lastSundayBeforeEndDate.isBefore(start)) {
      0
    } else {
      // We need to add 1 here since it is not inclusive
      Weeks.weeksBetween(firstSundayAfterStartDate, lastSundayBeforeEndDate).getWeeks() + 1
    }
  }

  override def result: String = {
    s"$numberOfSunday"
  }

  override def print: Unit = {
    println(s"(${start.toString(format)}, ${end.toString(format)}) => $result")
  }
}

object FindNumberOfSundaysTask {
  def initialize(start: DateTime, end: DateTime): FindNumberOfSundaysTask = {
    if (start.isAfter(end)) {
      throw new IllegalArgumentException(s"Start date can't be later than end date.")
    } else {
      FindNumberOfSundaysTask(start, end)
    }
  }
}