package com.versus

import akka.actor.{ActorSystem, Props}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.versus.actor.PingJobActor
import com.versus.repository.PingRepositoryImpl

class PingController extends Controller {

  get("/ping") { request: Request =>


    val pingActor = ActorSystem("PingActor").actorOf(Props[PingJobActor])


    pingActor ! "ping"

    val repo = new PingRepositoryImpl().ping()
    "pong"

  }
}
