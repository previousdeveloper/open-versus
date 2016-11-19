package com.versus.repository.cache

import com.versus.model.UserRequest
import com.versus.service.RedisService
import scala.pickling.Defaults._, scala.pickling.json._

trait UserCacheComponent {

  def saveUser(user: UserRequest): Boolean

  def getUser(email: String): User
}

class UserCacheService extends UserCacheComponent {

  override def saveUser(user: UserRequest): Boolean = {
    RedisService.set(user.email, user.pickle)
  }

  override def getUser(email: String): User = {

    RedisService.key(email).getOrElse("").unpickle[User]
  }
}

case class User(email: String, age: Int)

