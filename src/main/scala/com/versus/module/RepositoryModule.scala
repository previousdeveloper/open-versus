package com.versus.module

import com.twitter.inject.TwitterModule
import com.versus.configuration.Configuration
import scalikejdbc._
import scalikejdbc.config.DBsWithEnv


object RepositoryModule extends TwitterModule with Configuration {

  DBsWithEnv(env).setupAll()

//  DB autoCommit { implicit session =>
//    sql"""CREATE TABLE ping (
//    name VARCHAR(30) NOT NULL,
//    )""".update().apply()
//
//  }

}
