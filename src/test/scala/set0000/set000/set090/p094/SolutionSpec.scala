package set0000.set000.set090.p094

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1,null,2,3" should "get [1,3,2]" in {
    val root = new TreeNode(1)
    root.right = new TreeNode(2)
    root.right.left = new TreeNode(3)
    val res = Solution.inorderTraversal(root)
    res should equal(List(1, 3, 2))
  }

  "1,2,3,null,null,4" should "get [2,1,4,3]" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    root.right.left = new TreeNode(4)
    val res = Solution.inorderTraversal(root)
    res should equal(List(2, 1, 4, 3))
  }

  "1,2,3,5,null,4" should "get [2,5,1,4,3]" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.left.right = new TreeNode(5)
    root.right = new TreeNode(3)
    root.right.left = new TreeNode(4)
    val res = Solution.inorderTraversal(root)
    res should equal(List(2, 5, 1, 4, 3))
  }
}
