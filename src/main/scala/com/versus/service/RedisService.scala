package com.versus.service

import com.redis.RedisClient


object RedisService {

  val r = new RedisClient("redis", 6379)

  def set(key: String, value: String) = {
    r.set(key, value)
  }

  def key(key: String): Option[String] = {

    val result: Option[String] = r.get(key)

    result
  }
}
