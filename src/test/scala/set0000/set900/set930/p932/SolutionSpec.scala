package set0000.set900.set930.p932

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  private def check(arr: Array[Int]): Boolean = {
    val nums = arr.toSet
    if (nums.size != arr.size) {
      false
    } else {
      val n = arr.length
      for {
        i <- 0 until n
        j <- i + 2 until n
      } {
        for {
          k <- i + 1 until j
        } {
          if (arr(k) * 2 == arr(i) + arr(j)) {
            return false
          }
        }
      }
      true
    }
  }

  "example one" should "work" in {
    val res = Solution.beautifulArray(4)

    println(res.mkString(" "))

    check(res) should be(true)
  }

  "example two" should "work" in {
    val res = Solution.beautifulArray(5)

    println(res.mkString(" "))

    check(res) should be(true)
  }

  "example three" should "work" in {
    val res = Solution.beautifulArray(100)

    println(res.mkString(" "))

    check(res) should be(true)
  }
}
