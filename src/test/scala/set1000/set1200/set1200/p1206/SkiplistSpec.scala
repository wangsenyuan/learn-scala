package set1000.set1200.set1200.p1206

import org.scalatest.{FlatSpec, Matchers}

class SkiplistSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val skiplist = new Skiplist()
    skiplist.add(1)
    skiplist.add(2)
    skiplist.add(3)
    skiplist.search(0) should be(false)
    skiplist.add(4)
    skiplist.search(1) should be(true)
    skiplist.erase(0) should be(false)
    skiplist.erase(1) should be(true)
    skiplist.search(1) should be(false)
  }
}
