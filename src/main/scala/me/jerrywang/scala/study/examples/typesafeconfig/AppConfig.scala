package me.jerrywang.scala.study.examples.typesafeconfig

import com.typesafe.config.{ Config, ConfigFactory }

object AppConfig {
  val Conf: Config = ConfigFactory.load()

  val ProcessTimeout: Int = Conf.getInt("process.timeout.minutes")

  object S3Config {
    val RegionName: String = Conf.getString("aws.region")
    val OutputBucket: String = Conf.getString("output.bucket")
  }
}
