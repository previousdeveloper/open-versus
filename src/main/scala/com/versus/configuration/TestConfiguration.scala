package com.versus.configuration

import com.typesafe.config.{ConfigFactory, Config}

import scala.util.Properties


trait TestConfiguration {


  def ping: String
}

trait Configuration {

  val env = Properties.propOrElse("env", "dev")

  val config: Config = ConfigFactory.load().getConfig(env)
}


