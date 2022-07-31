package tasks

case class PhoneDataTask(
  data: String
) extends PersonalDataTask(data) {
  private def phone: String = {
    val builder: StringBuilder = new StringBuilder(data)

    for (i <- 0 until data.length) {
      if (builder(i) == ' ')
        builder(i) = '-'
    }

    builder.toString
  } 

  override protected def _obsfucate(data: String): String = {
    val builder: StringBuilder = new StringBuilder(phone)

    var remainingIgnores = 4

    val range = phone.take(1) match {
      case "+" => data.length - 1 to 1 by -1
      case _ => data.length - 1 to 0 by -1
    }

    for (i <- range) {
      builder(i) match {
        case '-' =>
        case _ if remainingIgnores > 0 => remainingIgnores -= 1
        case _ => builder(i) = '*'
      }
    }

    builder.toString
  }
}