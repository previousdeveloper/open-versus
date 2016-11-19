package com.versus.service

import com.redis.RedisClient


object RedisService {

  val r = new RedisClient("localhost", 6379)

  def set(key: String, value: Any): Boolean = {
    r.set(key, value)
  }

  def key(key: String): Option[String] = {

    val result: Option[String] = r.get(key)

    result
  }

}
