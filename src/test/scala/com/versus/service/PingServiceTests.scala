package com.versus.service

import com.versus.repository.`trait`.PingRepository
import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.specs2.mock.Mockito


class PingServiceTests extends FunSuite with Mockito {

  test("make ping") {
    val pingRepositoryMock = mock[PingRepository]
    when(pingRepositoryMock.ping()).thenReturn(true)
    val pingService = new PingServiceImpl(pingRepositoryMock)
    pingService.ping()

    verify(pingRepositoryMock, times(1)).ping()


  }
}
