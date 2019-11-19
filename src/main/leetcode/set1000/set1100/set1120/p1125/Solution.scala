package set1000.set1100.set1120.p1125

import scala.collection.mutable.ArrayBuffer

object Solution {
  val INF = 1 << 20

  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val n = req_skills.length
    val N = 1 << n
    val ii = req_skills.zipWithIndex.toMap
    val m = people.length

    val dp = Array.fill(N)(INF)
    dp(0) = 0


    val ps = people.toArray
    val pp = Array.ofDim[(Int, Int)](N)


    for {
      i <- 0 until m
    } {
      val mask = calMask(ps(i), ii)
      var x = N - 1
      while (x >= 0) {
        val state = mask | x
        if (dp(state) > dp(x) + 1) {
          dp(state) = dp(x) + 1
          pp(state) = x -> i
        }
        x -= 1
      }

    }

    val res = ArrayBuffer.empty[Int]

    var cur = N - 1
    while (cur > 0) {
      res += pp(cur)._2
      cur = pp(cur)._1
    }

    res.toArray
  }

  private def calMask(skills: List[String], ii: Map[String, Int]): Int = {
    var res = 0
    for {
      skill <- skills
    } {
      res |= 1 << ii(skill)
    }
    res
  }
}
