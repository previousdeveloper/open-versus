package com.versus.module

import com.twitter.inject.TwitterModule
import com.versus.configuration.Configuration
import scalikejdbc.AutoSession
import scalikejdbc.config.DBsWithEnv


object RepositoryModule extends TwitterModule with Configuration {

  DBsWithEnv(env).setupAll()

}
