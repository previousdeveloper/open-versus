package com.versus.service

import com.versus.model.UserRequest
import com.versus.repository.cache.{User, UserCacheComponent}


trait UserServiceComponent {

  def saveUser(user: UserRequest): Boolean

  def getUser(email: String): User
}

class UserService(userCache: UserCacheComponent) extends UserServiceComponent {


  override def saveUser(user: UserRequest): Boolean = {

    userCache.saveUser(user)
  }

  override def getUser(email: String): User = {
    userCache.getUser(email)
  }
}
