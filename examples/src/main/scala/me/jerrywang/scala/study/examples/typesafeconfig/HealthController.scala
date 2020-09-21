package me.jerrywang.scala.study.examples.typesafeconfig

import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class HealthController {

  @GetMapping(path = Array("/health"))
  def getHealth: ResponseEntity[Void] = new ResponseEntity(HttpStatus.OK)
}
