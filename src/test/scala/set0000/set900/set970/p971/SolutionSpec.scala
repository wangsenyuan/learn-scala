package set0000.set900.set970.p971

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    val voyage = Array(1, 3, 2)
    val res = Solution.flipMatchVoyage(root, voyage)
    res should be(List(1))
  }

  "example two" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    val voyage = Array(1, 2, 3)
    val res = Solution.flipMatchVoyage(root, voyage)
    res should be(List())
  }
}
