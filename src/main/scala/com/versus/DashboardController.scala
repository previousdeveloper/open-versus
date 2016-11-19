package com.versus

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.versus.model.UserRequest
import com.versus.repository.cache.UserCacheService
import com.versus.service.UserService


class DashboardController extends Controller {

  val userCache = new UserCacheService()
  val userService = new UserService(userCache)

  post("/user") { user: UserRequest => {


    userService.saveUser(user)
  }

    get("/user/:id") { request: Request => {
      val email = request.params("id")

      response.ok().json(userService.getUser(email))
    }
    }
  }
}
