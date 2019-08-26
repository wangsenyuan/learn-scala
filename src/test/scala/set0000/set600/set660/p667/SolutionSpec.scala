package set0000.set600.set660.p667

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "5,4" should "work" in {
    val res = Solution.constructArray(5, 4)
    val set = res.zip(res.tail).map(x => (x._1 - x._2).abs).toSet
    set.size should equal(4)
  }

  "10,9" should "work" in {
    val res = Solution.constructArray(10, 9)
    val set = res.zip(res.tail).map(x => (x._1 - x._2).abs).toSet
    set.size should equal(9)
  }

  "10,4" should "work" in {
    val res = Solution.constructArray(10, 4)
    val set = res.zip(res.tail).map(x => (x._1 - x._2).abs).toSet
    set.size should equal(4)
  }

  "10,3" should "work" in {
    val res = Solution.constructArray(10, 3)
    val set = res.zip(res.tail).map(x => (x._1 - x._2).abs).toSet
    set.size should equal(3)
  }
}
