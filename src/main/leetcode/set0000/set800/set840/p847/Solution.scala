package set0000.set800.set840.p847

object Solution {
  def shortestPathLength(graph: Array[Array[Int]]): Int = {
    // dp(i, mask)
    val n = graph.length
    val N = 1 << n
    val dp = Array.fill(n, N)(-1)

    val que = Array.ofDim[Int](n * N)
    var end = 0
    (0 until n).foreach(i => {
      dp(i)(1 << i) = 0
      que(end) = i * N + (1 << i)
      end += 1
    })

    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val i = cur / N
      val state = cur % N
      val row = graph(i)
      row.foreach(j => {
        val next = state | (1 << j)
        if (dp(j)(next) == -1) {
          dp(j)(next) = dp(i)(state) + 1
          que(end) = j * N + next
          end += 1
        }
      })
    }

    (0 until n).map(i => dp(i)(N - 1)).min
  }
}
