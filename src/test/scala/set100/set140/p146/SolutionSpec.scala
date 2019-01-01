package set100.set140.p146

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val cache = new LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.get(1) should be(1)
    cache.put(3, 3)
    cache.get(2) should be(-1)
    cache.put(4, 4)
    cache.get(1) should be(-1)
    cache.get(3) should be(3)
    cache.get(4) should be(4)
  }
}
