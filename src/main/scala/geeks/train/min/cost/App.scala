package geeks.train.min.cost

/**
 * Created by senyuanwang on 15/4/18.
 */
object App extends App {

  def travel(tickets: Array[Array[Int]]): Int = {
    val n = tickets.length
    val costs = Array.fill(n)(0)
    def go(idx: Int): Int =
      if (idx >= n) costs(n - 1)
      else {
        costs(idx) = (0 until idx).foldLeft(Int.MaxValue) {
          (result, i) =>
            result min costs(i) + tickets(i)(idx)
        }
        go(idx + 1)
      }

    go(1)
  }

  val INF = Int.MaxValue
  val test = Array(
    Array(0, 15, 80, 90),
    Array(INF, 0, 40, 50),
    Array(INF, INF, 0, 70),
    Array(INF, INF, INF, 0)
  )

  val minCost = travel(test)

  println(minCost)
}
