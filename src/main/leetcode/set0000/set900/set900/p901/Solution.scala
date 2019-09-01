package set0000.set900.set900.p901

object Solution {

  class StockSpanner() {
    var stack = List.empty[(Int, Int)]
    var i = 0

    def next(price: Int): Int = {
      while (!stack.isEmpty && stack.head._1 <= price) {
        stack = stack.tail
      }

      if (stack.isEmpty) {
        stack = (price -> i) :: stack
        i += 1
        i
      } else {
        val head = stack.head
        stack = (price -> i) :: stack

        val res = i - head._2

        i += 1

        res
      }
    }
  }

}
