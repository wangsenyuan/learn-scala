package codechef.hello

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/01/2017.
  */
object Main {

  case class Plan(m: Int, r: Double, c: Int)

  def findBestPlan(d: Double, u: Int, plans: Array[Plan]): Int = {
    def monthlyCost(plan: Plan): Double = {
      (plan.r * plan.m * u + plan.c) / plan.m
    }

    val costs = plans.map(monthlyCost)

    var minCost = d * u
    var i = 0
    var res = -1
    while (i < costs.length) {
      if (costs(i) < minCost) {
        res = i
        minCost = costs(i)
      }
      i += 1
    }
    res + 1
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val firstLine = StdIn.readLine().split("\\s+")
      val d = firstLine(0).toDouble
      val u = firstLine(1).toInt
      val n = firstLine(2).toInt

      val plans = Array.fill[Plan](n)(null)

      var i = 0
      while (i < n) {
        val line = StdIn.readLine().split("\\s+")
        plans(i) = Plan(line(0).toInt, line(1).toDouble, line(2).toInt)
        i += 1
      }

      val res = findBestPlan(d, u, plans)

      println(res)

      t -= 1
    }
  }
}
