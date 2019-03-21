package set400.set450.p450


object Solution {

  /**
    * Definition for a binary tree node.
    **/
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if(root == null) {
      null
    } else {
      if(root.value > key) {
        root.left = deleteNode(root.left, key)
        root
      } else if(root.value < key) {
        root.right = deleteNode(root.right, key)
        root
      } else if(root.left == null) {
        root.right
      } else if(root.right == null) {
        root.left
      } else {
        var cur = root.left
        if(cur.right == null) {
          cur.right = root.right
          cur
        } else {
          // tmp will be the new root
          var tmp = cur.right
          while(tmp.right != null) {
            cur = tmp
            tmp = tmp.right
          }
          cur.right = tmp.left
          tmp.right = root.right
          tmp.left = root.left
          tmp
        }
      }
    }
  }
}
