package actors

sealed trait Message

case class Work(taskNb: Int) extends Message
case class WorkCompleted(taskNb: Int, duration: Int) extends Message

case class Dispatch(taskNb: Int) extends Message