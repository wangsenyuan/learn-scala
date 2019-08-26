package set0000.set200.set220.p222

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,2,3,4]" should "get 4" in {
    val tree = new TreeNode(1)
    tree.left = new TreeNode(2)
    tree.left.left = new TreeNode(4)
    tree.right = new TreeNode(3)
    val res = Solution.countNodes(tree)
    res should be(4)
  }
}
