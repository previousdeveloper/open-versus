package com.versus.repository

import scalikejdbc._

trait PingRepositoryComponent {

  def ping(): Boolean
}

class PingRepository extends PingRepositoryComponent {

  override def ping(): Boolean = {

    DB autoCommit { implicit session =>

      val execute: Int = sql"""insert into ping (name) values ('pong')""".update().apply()

      execute == 1
    }
  }
}


