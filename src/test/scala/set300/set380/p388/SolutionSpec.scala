package set300.set380.p388

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "get 20" in {
    val res = Solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    res should be(20)
  }

  "example two" should "get 12" in {
    val res = Solution.lengthLongestPath("dir\n\tfile.ext");
    res should be(12)
  }

  "example three" should "get 12" in {
    val res = Solution.lengthLongestPath("dir\n    file.ext");
    res should be(12)
  }
}
