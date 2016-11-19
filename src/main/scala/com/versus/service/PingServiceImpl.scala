package com.versus.service

import com.versus.repository.PingRepository


class PingServiceImpl(pingRepository: PingRepository) extends PingService {

  override def ping(): Unit = {

    pingRepository.ping()

  }
}
