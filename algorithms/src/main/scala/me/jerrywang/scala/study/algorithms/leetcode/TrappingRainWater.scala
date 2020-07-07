package me.jerrywang.scala.study.algorithms.leetcode

import scala.math.max

// LC 42
object TrappingRainWater {

  def trap(height: Array[Int]): Int = {
    if (height.length == 0)
      return 0

    val n = height.length
    var l = 0
    var r = n - 1
    var max_l = height(l)
    var max_r = height(r)
    var ans = 0

    while (l < r) {
      if (max_l < max_r) {
        ans += max_l - height(l)
        l += 1
        max_l = max(max_l, height(l))
      } else {
        ans += max_r - height(r)
        r -= 1
        max_r = max(max_r, height(r))
      }
    }

    ans
  }
}
