package tasks

class PersonalDataTask(
  data: String
) extends BaseTask {
  protected def _obsfucate(data: String): String = {
    val builder: StringBuilder = new StringBuilder(data)

    for (i <- 1 until data.length - 1) {
      builder(i) = '*'
    }

    builder.toString
  }

  override def result: String = {
    _obsfucate(data)
  }

  override def print: Unit = {
    println(s"$data => $result")
  }
}

object PersonalDataTask {
  private val phoneRegex = """^((?:(?:\+?\d{1,3})|(?:\d{1,4})) \d{1,3} \d{1,4} \d{1,4})$""".r
  private val emailRegex = """^(([a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+)@([a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*))$""".r
  
  def initialize(data: String): PersonalDataTask = {
    data match {
      case phoneRegex(phone) => PhoneDataTask(phone)
      case emailRegex(email, name, domain) => EmailDataTask(email, name, domain)
      case _ => throw new IllegalArgumentException("Data is not a phone number or email.")
    }
  }
}