package tasks

case class EmailDataTask(
  email: String,
  name: String,
  domain: String,
) extends PersonalDataTask(email) {
  override protected def _obsfucate(data: String): String = {
    val firstChar = data.take(1)
    val lastChar = data.takeRight(1)

    s"$firstChar*****$lastChar"
  }

  override def result: String = {
    s"${_obsfucate(name)}@$domain".toLowerCase
  }
}