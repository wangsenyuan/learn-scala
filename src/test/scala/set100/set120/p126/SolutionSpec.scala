package set100.set120.p126

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val begin = "hit"
    val end = "cog"
    val words = List("hot", "dot", "dog", "lot", "log", "cog")
    val res = Solution.findLadders(begin, end, words)
    res.size should be(2)
    val first = res.head
    val last = res.last
    first.size should be(5)
    last.size should be(5)

    val expect = List(List("hit", "hot", "dot", "dog", "cog"), List("hit", "hot", "lot", "log", "cog")).sortWith(compareList)
    res.sortWith(compareList) should equal(expect)
  }

  "example two" should "work" in {
    val begin = "a"
    val end = "c"
    val words = List("a", "b", "c")
    val res = Solution.findLadders(begin, end, words)
    res.size should be(1)

    val expect = List(List("a", "c"))
    res should equal(expect)
  }

  "example three" should "work" in {
    val begin = "hit"
    val end = "cog"
    val words = List("hot", "cog", "dot", "dog", "hit", "lot", "log")
    val res = Solution.findLadders(begin, end, words)
    res.size should be(2)
    val first = res.head
    val last = res.last
    first.size should be(5)
    last.size should be(5)

    val expect = List(List("hit", "hot", "dot", "dog", "cog"), List("hit", "hot", "lot", "log", "cog")).sortWith(compareList)
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
