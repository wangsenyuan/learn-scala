package set0000.set400.set460.p460

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val cache = new LFUCache(0)
    cache.put(0, 0)
    val res = cache.get(0)
    res should be(-1)
  }

  "example two" should "work" in{
    val cache = new LFUCache(3)
    cache.put(2, 2)
    cache.put(1, 1)
    var res = cache.get(2)
    res should be(2)
    res = cache.get(1)
    res should be(1)
    res = cache.get(2)
    res should be(2)
    cache.put(3, 3)
    cache.put(4, 4)
    res = cache.get(3)
    res should be(-1)
    res = cache.get(2)
    res should be(2)
    res = cache.get(1)
    res should be(1)
    res = cache.get(4)
    res should be(4)
  }

  "example three" should "work" in {
    val cache = new LFUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.get(1) should be(1)
    cache.put(3, 3)
    cache.get(2) should be(-1)
    cache.get(3) should be(3)
    cache.put(4, 4)
    cache.get(1) should be(-1)
    cache.get(3) should be(3)
    cache.get(4) should be(4)
  }
}
