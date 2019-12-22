package set1000.set1200.set1260.p1261

import org.scalatest.{FlatSpec, Matchers}

class FindElementsSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val tree = new TreeNode(0)
    tree.right = new TreeNode(0)
    val finder = new FindElements(tree)
    finder.find(2) should be(true)
  }
}
