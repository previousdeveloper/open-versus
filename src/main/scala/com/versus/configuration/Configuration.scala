package com.versus.configuration

import com.typesafe.config.{Config, ConfigFactory}

import scala.util.Properties


class Configuration extends TestConfiguration {

  val env = Properties.propOrElse("env", "dev")

  val config: Config = ConfigFactory.load().getConfig(env)

  override def ping: String = {

    val result: String = config.getString("ping")
    result
  }
}
