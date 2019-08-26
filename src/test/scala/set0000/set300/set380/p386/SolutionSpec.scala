package set0000.set300.set380.p386

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "13" should "get [1,10,11,12,13,2,3,4,5,6,7,8,9]." in {
    val res = Solution.lexicalOrder(13)
    res should equal(List(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9))
  }

  "100" should "work" in {
    val res = Solution.lexicalOrder(100)
    println(res)
  }


  "1000" should "work" in {
    val res = Solution.lexicalOrder(1000)
    res foreach println
  }
}
