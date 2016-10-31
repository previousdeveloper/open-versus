package com.example.configuration

import org.scalatest.FunSuite


class ConfigurationTest extends FunSuite {

  test("Configuration load correctly") {
    val configuration = new Configuration

    assert(configuration.ping == "PongDev")
  }
}
