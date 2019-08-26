package set0000.set600.set630.p634

object Solution {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {

    val res = Array.ofDim[Int](n)
    var stack = List.empty[(Int, Int)]

    def process(log: String): Unit = {
      val ss = log.split(":")
      val id = ss(0).toInt
      val op = ss(1)
      val ts = ss(2).toInt
      if (op == "start") {
        stack = (id -> ts) :: stack
      } else {
        val (_, s) = stack.head
        res(id) += ts - s + 1
        stack = stack.tail
        if(stack.size > 0) {
          val (p, _) = stack.head
          res(p) -= ts - s + 1
        }
      }
    }

    logs.foreach(process)

    res
  }

}
