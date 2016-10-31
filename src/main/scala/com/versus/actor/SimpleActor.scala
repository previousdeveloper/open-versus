package com.versus.actor

import akka.actor.{Props, Actor}


class SimpleActor extends Actor {

  override def receive: Receive = {

    case str: String => println(str)

  }
}

class PingJobActor extends Actor {
  val restJobActor = context.actorOf(Props[SimpleActor])

  override def receive: Receive = {
    case "ping" => restJobActor ! "ping"
    case _ => sender ! "Error"
  }
}
