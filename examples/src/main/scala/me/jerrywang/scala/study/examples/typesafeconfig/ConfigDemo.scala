package me.jerrywang.scala.study.examples.typesafeconfig

import scala.reflect.runtime.currentMirror
import scala.reflect.runtime.universe._

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ConfigDemo

object ConfigDemo extends App {

  // eager instantiation of singleton objects in a type
  def verifyModule(t: Type): Unit = {
    t.decls.collect {
      case m: ModuleSymbol => currentMirror.reflectModule(m).instance
    }
  }

  // fail-fast if any configuration is missing
  verifyModule(typeOf[AppConfig.type])

  SpringApplication.run(classOf[ConfigDemo], args: _*)
}
