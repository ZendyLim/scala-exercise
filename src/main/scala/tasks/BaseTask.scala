package tasks

trait BaseTask {
  def result: String
  def print: Unit = println(result)
}