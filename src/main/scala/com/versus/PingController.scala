package com.versus

import akka.actor.{ActorSystem, Props}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.versus.actor.PingJobActor
import scalikejdbc._

class PingController extends Controller {

  get("/ping") { request: Request =>

    DB autoCommit { implicit session =>
      val jobs =
        sql"""insert into test (deneme) values (1)""".update().apply()

    }

    val pingActor = ActorSystem("PingActor").actorOf(Props[PingJobActor])

    pingActor ! "ping"

    "pong"

  }
}
