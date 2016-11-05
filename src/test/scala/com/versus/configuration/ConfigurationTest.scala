package com.versus.configuration

import org.scalatest.FunSuite


class ConfigurationTest extends FunSuite {

  test("Configuration load correctly") {
    val configuration = new ConfigurationImpl

    assert(configuration.ping == "PongDev")
  }
}
