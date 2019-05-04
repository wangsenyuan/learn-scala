package set600.set600.p609

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val paths = Array("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)")
    val res = Solution.findDuplicate(paths)
    res should equal(List(List("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), List("root/a/1.txt", "root/c/3.txt")))
  }
}
