package me.jerrywang.scala.study.examples.typesafeconfig

import java.nio.file.{ Path, Paths }

import com.typesafe.config.{ Config, ConfigFactory }

import scala.util.Try

object AppConfig {

  private val Conf: Config = ConfigFactory.load()

  val ProcessTimeout: Int = Conf.getInt("process.timeout.minutes")

  val uuids = Try(Paths.get(Conf.getString("uuids.path"))).toOption

  object S3Config {
    val RegionName: String = Conf.getString("aws.region")
    val OutputBucket: String = Conf.getString("output.bucket")
  }

}
