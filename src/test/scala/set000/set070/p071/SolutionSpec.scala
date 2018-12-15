package set000.set070.p071

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "simplify /home/" should "get /home" in {
    Solution.simplifyPath("/home/") should be("/home")
  }

  "simplify /a/./b/../../c/" should "get /c" in {
    Solution.simplifyPath("/a/./b/../../c/") should be("/c")
  }

  "simplify /a/../../b/../c//.//" should "get /c" in {
    Solution.simplifyPath("/a/../../b/../c//.//") should be("/c")
  }

  "simplify /a//b////c/d//././/.." should "get /a/b/c" in {
    Solution.simplifyPath("/a//b////c/d//././/..") should be("/a/b/c")
  }

  "simplify /../" should "get /" in {
    Solution.simplifyPath("/../") should be("/")
  }
}
