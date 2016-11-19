package com.versus.model

import com.versus.utils.EmailValidator


case class PingRequest(id: String)

case object PingRequest {

  import com.wix.accord.dsl._

  implicit val personValidator = validator[PingRequest] { req =>
    req.id is notEmpty
    req.id.length should be >= 0
  }
}


case class UserRequest(email: String, name: String, age: Int)

case object UserRequest {

  import com.wix.accord.dsl._

  implicit val userRequestvalidator = validator[UserRequest] { req =>

    req.age should be > 0
    req.email is notNull
    req.name is notNull
    EmailValidator.check(req.email) should true


  }

}