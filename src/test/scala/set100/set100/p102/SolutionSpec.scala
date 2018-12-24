package set100.set100.p102

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[3,9,20,null,null,15,7]" should "get [[3], [9, 20], [15,7]]" in {
    val root = new TreeNode(3)
    root.left = new TreeNode(9)
    root.right = new TreeNode(20)
    root.right.left = new TreeNode(15)
    root.right.right = new TreeNode(7)

    val res = Solution.levelOrder(root)

    res.size should be(3)
    res.head should equal(List(3))
    res.tail.head should equal(List(9, 20))
    res.last should equal(List(15, 7))
  }
}
