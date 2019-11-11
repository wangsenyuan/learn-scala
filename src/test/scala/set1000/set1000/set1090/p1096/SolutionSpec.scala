package set1000.set1000.set1090.p1096

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.braceExpansionII("{a,b}{c,{d,e}}")
    res should be(Array("ac", "ad", "ae", "bc", "bd", "be"))
  }

  "example two" should "work" in {
    val res = Solution.braceExpansionII("{{a,z},a{b,c},{ab,z}}")
    res should be(List("a", "ab", "ac", "z"))
  }

  "example three" should "work" in {
    val res = Solution.braceExpansionII("{a,b}c{d,e}f")
    res should be(List("acdf", "acef", "bcdf", "bcef"))
  }
}
