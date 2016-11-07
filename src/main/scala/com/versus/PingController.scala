package com.versus

import akka.actor.{ActorSystem, Props}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.versus.actor.PingJobActor
import com.versus.model.PingRequest
import com.versus.service.RedisService

class PingController extends Controller {

  get("/ping") { request: Request =>


    val pingActor = ActorSystem("PingActor").actorOf(Props[PingJobActor])


    RedisService.set("testKey", "testValue")

    //    val validatorResult: Result = validate(request)
    //
    //    println(validatorResult.isSuccess)

    pingActor ! "ping"

    println("pong")

    RedisService.key("testKey")

  }
}
