package set0000.set600.set620.p621

import scala.collection.mutable

object Solution {
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val m = tasks.length
    if (n == 0) {
      m
    } else {
      val cnt = Array.ofDim[Int](26)
      for {
        task <- tasks
      } {
        cnt(task - 'A') += 1
      }
      val q = mutable.PriorityQueue.empty[Int]
      q.enqueue(cnt.filter(_ > 0): _*)

      var res = 0

      while(!q.isEmpty) {
        var left = List.empty[Int]
        var i = 0
        while(i <= n && !q.isEmpty) {
          val cur = q.dequeue()
          res += 1
          if(cur > 1) {
            left = (cur - 1) :: left
          }
          i += 1
        }
        if(!left.isEmpty) {
          res += n - i + 1
        }
        q.enqueue(left :_*)
      }

      res
    }
  }
}
