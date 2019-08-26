package set0000.set100.set130.p131

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "aab" should "get 2 result" in {
    val res = Solution.partition("aab")
    res.size should be(2)

    val expect = List(List("aa", "b"), List("a", "a", "b")).sortWith(compareList)

    res.sortWith(compareList) should equal(expect)
  }

  private def compareList(a: List[String], b: List[String]): Boolean = {
    val c = a.zip(b).dropWhile(x => x._1 == x._2)

    if (c.isEmpty) {
      true
    } else {
      val h = c.head
      val (x, y) = h
      x.compareTo(y) <= 0
    }
  }
}
