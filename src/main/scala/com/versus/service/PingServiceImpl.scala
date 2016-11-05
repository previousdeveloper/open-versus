package com.versus.service

import com.versus.repository.`trait`.PingRepository


class PingServiceImpl(pingRepository: PingRepository) extends PingService {

  override def ping(): Unit = {

    pingRepository.ping()

  }
}
