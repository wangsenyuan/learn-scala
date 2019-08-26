package set0000.set000.set050.p057

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "insert [2, 5] into [1,3],[6,9]" should "result [1,5],[6,9]" in {
    val res = Solution.insert(List(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5))
    res.size should be(2)
    res.head.end should be(5)
  }

  "insert [4, 8] into [[1,2],[3,5],[6,7],[8,10],[12,16]]" should "result [[1,2],[3,10],[12,16]]" in {
    val intervals = List(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16))
    val res = Solution.insert(intervals, new Interval(4, 8))
    res.size should be(3)
    val second = res.tail.head
    second.start should be(3)
    second.end should be(10)
  }
}
