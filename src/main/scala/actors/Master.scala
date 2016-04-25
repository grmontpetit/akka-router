package actors

import akka.actor.{Props, Actor}
import akka.routing.{RoundRobinPool}
import akka.util.Timeout
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class Master extends Actor {

  implicit val timeout = Timeout(2 seconds)

  val router = context.actorOf(Props[Worker].withRouter(RoundRobinPool(nrOfInstances = 5)), "router")

  def receive = {
    case Dispatch(taskNb) => {
      println("MASTER: Dispatching task #" + taskNb)
      router ! Work(taskNb)
    }
    case WorkCompleted(getIdentifier, taskNb, time) => {
      println("MASTER: Worker #" + getIdentifier + " completed task #" + taskNb + " in " + time + " ms")
    }
    case _ => Unit // Do nothing
  }
}
