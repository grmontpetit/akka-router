package actors

import akka.actor.Actor

import scala.language.postfixOps
import scala.util.Random

class Worker() extends Actor {

  def receive = {
    case Work(taskNb) => {
      println("WORKER: Working on task #" + taskNb)
      val time = randomTime
      doWork(time)
      sender ! WorkCompleted(taskNb, time)
    }
  }

  def randomTime: Int = {
    val rnd = new Random()
    1000 + rnd.nextInt((5000 - 1000) + 1)
  }

  def doWork(time: Int) = Thread sleep time

}
