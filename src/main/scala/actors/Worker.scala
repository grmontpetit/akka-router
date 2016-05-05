package com.sniggel.akkarouter.actors

import akka.actor.Actor

import scala.language.postfixOps
import scala.util.Random

class Worker() extends Actor {

  def receive = {
    case Work(taskNb) => {
      println("WORKER" + getIdentifier + ": started working on task #" + taskNb)
      val time = randomTime
      doWork(time)
      sender ! WorkCompleted(getIdentifier, taskNb, time)
    }
  }

  private def randomTime: Int = {
    val rnd = new Random()
    1000 + rnd.nextInt((5000 - 1000) + 1)
  }

  private def doWork(time: Int) = Thread sleep time

  private def getIdentifier: Int = self.path.toString match {
    case (x) if x contains """$a""" => 1
    case (x) if x contains """$b""" => 2
    case (x) if x contains """$c""" => 3
    case (x) if x contains """$d""" => 4
    case (x) if x contains """$e""" => 5
  }
}
