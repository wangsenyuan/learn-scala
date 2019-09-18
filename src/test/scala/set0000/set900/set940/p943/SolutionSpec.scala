package set0000.set900.set940.p943

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  private def checkResult(res: String, expect: String, arr: Array[String]): Boolean = {
    if (res == expect) {
      true
    } else if (res.length != expect.length) {
      false
    } else {
      arr.forall(x => res.contains(x))
    }
  }

  "example one" should "work" in {
    val arr = Array("alex", "loves", "leetcode")
    val res = Solution.shortestSuperstring(arr)
    checkResult(res, "alexlovesleetcode", arr) should be(true)
  }

  "example two" should "work" in {
    val arr = Array("catg", "ctaagt", "gcta", "ttca", "atgcatc")
    val res = Solution.shortestSuperstring(arr)
    checkResult(res, "gctaagttcatgcatc", arr) should be(true)
  }
}
