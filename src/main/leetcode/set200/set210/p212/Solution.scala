package set200.set210.p212


object Solution {

  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    class Node {
      val children = Array.fill[Node](26)(null)
      var leaf = false

      def add(word: String): Unit = {
        if (word.isEmpty) {
          leaf = true
        } else {
          val idx = word.head - 'a'
          if (children(idx) == null) {
            children(idx) = new Node()
          }
          children(idx).add(word.tail)
        }
      }

      def next(c: Char): Node = {
        val idx = c - 'a'
        children(idx)
      }
    }

    if (board.length == 0 || board(0).length == 0) {
      Nil
    } else {
      val root = new Node()

      for {
        word <- words
      } {
        root.add(word)
      }

      val m = board.length
      val n = board(0).length

      val vis = Array.fill(m, n)(false)

      val dd = Array(-1, 0, 1, 0, -1)

      var res = List.empty[String]

      def dfs(x: Int, y: Int, nodes: List[Node], path: String): Unit = {
        vis(x)(y) = true
        if (!nodes.isEmpty) {
          if (nodes.exists(_.leaf)) {
            res = path :: res
          }

          for {
            k <- 0 until 4
            u = x + dd(k)
            v = y + dd(k + 1)
            if u >= 0 && u < m && v >= 0 && v < n && !vis(u)(v)
          } {
            val newNodes = nodes.map(_.next(board(u)(v))).filter(_ != null)
            dfs(u, v, newNodes, path + board(u)(v))
          }
        }

        vis(x)(y) = false
      }

      for {
        i <- 0 until m
        j <- 0 until n
      } {
        val next = root.next(board(i)(j))
        if (next != null) {
          dfs(i, j, List(next), "" + board(i)(j))
        }
      }

      res.distinct
    }
  }
}
