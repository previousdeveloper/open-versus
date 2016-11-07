package com.versus.model


case class PingRequest(id: String)

//case object PingRequest {
//
//  import com.wix.accord.dsl._
//
//  implicit val personValidator = validator[PingRequest] { req =>
//    req.id is notEmpty
//    req.id.length should be >= 0
//  }
//}