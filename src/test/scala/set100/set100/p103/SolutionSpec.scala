package set100.set100.p103

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example 1 " should "get [3], [20,9],[15,7]" in {
    val root = new TreeNode(3)
    root.left = new TreeNode(9)
    root.right = new TreeNode(20)
    root.right.left = new TreeNode(15)
    root.right.right = new TreeNode(7)
    val res = Solution.zigzagLevelOrder(root)
    res.size should be(3)
    res.head should equal(List(3))
    res.tail.head should equal(List(20, 9))
    res.last should equal(List(15, 7))
  }
}
