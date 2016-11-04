package com.versus.repository

import com.versus.repository.`trait`.PingRepository
import scalikejdbc._


class PingRepositoryImpl extends PingRepository {

  override def ping(): Boolean = {

    DB autoCommit { implicit session =>

      val execute: Int = sql"""insert into ping (name) values ('pong')""".update().apply()

      execute == 1
    }
  }
}


