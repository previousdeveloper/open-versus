package com.versus.configuration

import com.typesafe.config.{Config, ConfigFactory}

import scala.util.Properties


class ConfigurationImpl extends TestConfiguration with Configuration {

  override def ping: String = {

    val result: String = config.getString("ping")
    result
  }
}
