package com.versus

import akka.actor.{ActorSystem, Props}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.versus.actor.PingJobActor
import com.versus.service.RedisService

class PingController extends Controller {

  get("/ping") { request: Request =>


    val pingActor = ActorSystem("PingActor").actorOf(Props[PingJobActor])


    RedisService.set("testKey", "testValue")


    pingActor ! "ping"

    println("pong")

    RedisService.key("testKey")

  }
}
